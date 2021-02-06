package dh.covid.api.services;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.vo.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {

    Page<Country> getCountries(Pageable pageable);
    List<Country> findAll();
    Page<Country> getTopCountries(Integer top);
    Country getCountryById(Integer id);
    void save(CountryDTO country);
    List<CountryDTO> saveAll(List<CountryDTO> country);
    void deleteAll();

    Country getCountryByName(String name);
}
