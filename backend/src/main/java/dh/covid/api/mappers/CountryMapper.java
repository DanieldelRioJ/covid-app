package dh.covid.api.mappers;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.vo.Country;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CountryMapper {

    public abstract CountryDTO toCountryDTO(Country country);
    public abstract List<CountryDTO> toCountryDTO(List<Country> country);
    public abstract Country toCountry(CountryDTO countryDTO);
    public abstract List<Country> toCountry(List<CountryDTO> countryDTO);

    @AfterMapping
    protected void ignoreFathersChildren(Country country, @MappingTarget CountryDTO countryDTO) {
        System.out.println(country);
        if(countryDTO.getVaccines() != null){
            countryDTO.getVaccines().forEach(vaccineDTO -> vaccineDTO.setCountries(null));
        }
        if(countryDTO.getVaccineSeries() != null){
            countryDTO.getVaccineSeries().forEach(vaccinationSeriesDTO -> vaccinationSeriesDTO.setCountry(null));
        }
    }

}
