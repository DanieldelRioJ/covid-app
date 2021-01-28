package dh.covid.api.mappers;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.vo.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDTO toCountryDTO(Country country);
    List<CountryDTO> toCountryDTO(List<Country> country);
    Country toCountry(CountryDTO countryDTO);
    List<Country> toCountry(List<CountryDTO> countryDTO);

}
