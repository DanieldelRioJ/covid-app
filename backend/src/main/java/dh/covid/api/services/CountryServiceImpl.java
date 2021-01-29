package dh.covid.api.services;

import dh.covid.api.mappers.CountryMapper;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    public CountryServiceImpl(){

    }

    @Override
    public List<CountryDTO> getCountries(){
        return countryMapper.toCountryDTO(countryRepository.findAll());
    }

    @Override
    public CountryDTO getCountryById(String id) {
        return null;
    }

    @Override
    public void save(CountryDTO country) {
        this.countryRepository.save(countryMapper.toCountry(country));
    }

    @Override
    public List<CountryDTO> saveAll(List<CountryDTO> country) {
        List<Country> countryList = countryMapper.toCountry(country);
        countryList = this.countryRepository.saveAll(countryList);
        return countryMapper.toCountryDTO(countryList);
    }

    @Override
    public void deleteAll() {
        this.countryRepository.deleteAll();
    }
}