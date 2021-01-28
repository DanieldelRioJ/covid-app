package dh.covid.api.services;

import dh.covid.api.mappers.CountryMapper;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.repositories.CountryRepository;
import org.mapstruct.factory.Mappers;
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
    public void saveAll(List<CountryDTO> country) {
        this.countryRepository.saveAll(countryMapper.toCountry(country));
    }

    @Override
    public void deleteAll() {
        this.countryRepository.deleteAll();
    }
}
