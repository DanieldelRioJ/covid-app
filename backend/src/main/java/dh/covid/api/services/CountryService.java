package dh.covid.api.services;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.vo.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();
    Country getCountryById(Integer id);
    void save(CountryDTO country);
    List<CountryDTO> saveAll(List<CountryDTO> country);
    void deleteAll();
}
