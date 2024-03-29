package dh.covid.api.services;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.external_fetchers.VaccinationsExternalFetcher;
import dh.covid.api.mappers.CsvModelMapper;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.dto.VaccinationSeriesDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.dto.WorldSeriesDTO;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.utils.BlackList;
import dh.covid.api.utils.Pair;
import dh.covid.api.utils.Trio;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DataDumperImpl implements DataDumper {

    @Autowired
    private CountryService countryService;
    @Autowired
    private VaccineService vaccineService;
    @Autowired
    private WorldSeriesService worldSeriesService;

    @Autowired
    private LocationsExternalFetcher locationsExternalFetcher;
    @Autowired
    private VaccinationsExternalFetcher vaccinationsExternalFetcher;
    @Autowired
    private VaccinationSeriesService vaccinationSeriesService;

    @Autowired
    private CsvModelMapper csvModelMapper;

    @Override
    public void dumpData(List<Country> countries, List<Vaccine> vaccines, List<VaccinationSeries> vaccinationSeries) {
        //countryRepository.saveAll(countries);
        //vaccineRepository.saveAll(vaccines);
        //vaccinationSeriesRepository.saveAll(vaccinationSeries);
    }

    @Override
    public void dumpData(List<Country> countries) {
        //countryRepository.saveAll(countries);
    }

    /*Each hour, fetch CSV files and stores converted data into DB*/
    @Scheduled(fixedRate = 3600000)
    //@Transactional
    public void autoReload() throws Exception {
        List<LocationCSV> locations = locationsExternalFetcher.getItems().stream().filter(location -> !BlackList.inBlackList(location.getLocation())).collect(Collectors.toList());
        List<VaccinationCSV> vaccinationsCSV = vaccinationsExternalFetcher.getItems();
        List<VaccinationCSV> worldVaccinationSeriesCSV = vaccinationsCSV.stream().filter( v -> v.getCountryName().equals("World")).collect(Collectors.toList());
        List<WorldSeriesDTO> worldSeriesDTOList = csvModelMapper.convertVaccinationsCSVTOWorldLocationSeries(worldVaccinationSeriesCSV);
        Trio<List<CountryDTO>, List<VaccineDTO>, List<VaccinationSeriesDTO>> trio = csvModelMapper.convertLocationCSVToCountryDTO(locations, vaccinationsCSV);

        countryService.deleteAll();
        vaccineService.deleteAll();
        worldSeriesService.deleteAll();
        worldSeriesService.saveAll(worldSeriesDTOList);
        vaccinationSeriesService.deleteAll();
        try{
            countryService.saveAll(trio.t);
        }catch (LazyInitializationException e){
            System.out.println("Litle exception!");
        }

        try{
            vaccinationSeriesService.saveAll(trio.v);
        }catch (LazyInitializationException e){
            System.out.println("Litle exception!");
        }
    }
}
