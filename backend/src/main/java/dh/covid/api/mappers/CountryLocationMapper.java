package dh.covid.api.mappers;

import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.internal.dto.CountryDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryLocationMapper {

    public CountryDTO convertLocationCSVToCountryDTO(LocationCSV locationCSV){

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setName(locationCSV.getLocation());
        countryDTO.setIsoCode(locationCSV.getIsoCode());

        Date date = Date.from(locationCSV.getLastObservationDate().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        countryDTO.setLastObservationDate(date);

        countryDTO.setSourceWebsite(locationCSV.getSourceWebsite());
        countryDTO.setSourceName(locationCSV.getSourceName());

        return countryDTO;
    }

    public List<CountryDTO> convertLocationCSVToCountryDTO(List<LocationCSV> locationCSVList){

        List<CountryDTO> countryDTOList = locationCSVList.stream().map(locationCSV -> {
            CountryDTO countryDTO = convertLocationCSVToCountryDTO(locationCSV);
            return countryDTO;
        }).collect(Collectors.toList());

        return countryDTOList;
    }
}
