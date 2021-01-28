package dh.covid.api.services;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.external_fetchers.VaccinationsExternalFetcher;
import dh.covid.api.mappers.CountryLocationMapper;
import dh.covid.api.mappers.CountryMapper;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.repositories.CountryRepository;
import dh.covid.api.repositories.VaccinationSeriesRepository;
import dh.covid.api.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDumperImpl implements DataDumper {

    @Autowired
    private CountryService countryService;

    @Autowired
    private LocationsExternalFetcher locationsExternalFetcher;
    @Autowired
    private VaccinationsExternalFetcher vaccinationsExternalFetcher;

    @Autowired
    private CountryLocationMapper countryLocationMapper;

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

    @Override
    public void autoReload() throws Exception {
        List<LocationCSV> locations = locationsExternalFetcher.getItems();
        List<VaccinationCSV> vaccinationsCSV = vaccinationsExternalFetcher.getItems();

        List<CountryDTO> countryDTOList = countryLocationMapper.convertLocationCSVToCountryDTO(locations);
        countryService.deleteAll();
        countryService.saveAll(countryDTOList);
    }
}
