package dh.covid.api.services;

import dh.covid.api.models.internal.dto.CountryDTO;

import java.util.List;

public interface CountryService {

    List<CountryDTO> getCountries();
    CountryDTO getCountryById(String id);
    void save(CountryDTO country);
    void saveAll(List<CountryDTO> country);
    void deleteAll();
}
