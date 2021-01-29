package dh.covid.api.services;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.external_fetchers.VaccinationsExternalFetcher;
import dh.covid.api.mappers.CsvModelMapper;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.dto.VaccinationSeriesDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.utils.Pair;
import dh.covid.api.utils.Trio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataDumperImpl implements DataDumper {

    @Autowired
    private CountryService countryService;
    @Autowired
    private VaccineService vaccineService;

    @Autowired
    private LocationsExternalFetcher locationsExternalFetcher;
    @Autowired
    private VaccinationsExternalFetcher vaccinationsExternalFetcher;

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
    public void autoReload() throws Exception {
        List<LocationCSV> locations = locationsExternalFetcher.getItems();
        List<VaccinationCSV> vaccinationsCSV = vaccinationsExternalFetcher.getItems();


        Trio<List<CountryDTO>, List<VaccineDTO>, List<VaccinationSeriesDTO>> trio = csvModelMapper.convertLocationCSVToCountryDTO(locations, vaccinationsCSV);

        countryService.deleteAll();
        vaccineService.deleteAll();
        List<VaccineDTO> vaccines = vaccineService.saveAll(trio.u);
        Map<String, VaccineDTO> vaccineRegister = new HashMap<>();
        for (VaccineDTO vaccine: vaccines){
            vaccineRegister.put(vaccine.getName(), vaccine);
        }

        trio.t.forEach(countryDTO -> {
            List<VaccineDTO> vacAuxList = countryDTO.getVaccines();
            if(vacAuxList != null){
                vacAuxList.forEach(vaccine -> {
                    VaccineDTO vac = vaccineRegister.get(vaccine.getName());
                    vaccine.setId(vac.getId());
                });
            }
        });
        countryService.saveAll(trio.t);
    }
}
