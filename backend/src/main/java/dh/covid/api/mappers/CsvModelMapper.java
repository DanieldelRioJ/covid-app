package dh.covid.api.mappers;

import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.dto.VaccinationSeriesDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.utils.Pair;
import dh.covid.api.utils.Trio;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class CsvModelMapper {

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

    public VaccinationSeriesDTO convertVaccinationsCSVToVaccionationSeriesDTO(VaccinationCSV vaccinationCSV){
        VaccinationSeriesDTO vaccinationSeriesDTO = new VaccinationSeriesDTO();
        vaccinationSeriesDTO.setDailyVaccinationsRaw(vaccinationCSV.getDailyVaccinationsRaw());
        vaccinationSeriesDTO.setDailyVaccionations(vaccinationCSV.getDailyVaccionations());
        vaccinationSeriesDTO.setDailyVaccionationsPerMillion(vaccinationCSV.getDailyVaccionationsPerMillion());

        Date date = Date.from(vaccinationCSV.getDate().atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        vaccinationSeriesDTO.setDate(date);
        vaccinationSeriesDTO.setPeopleVaccinated(vaccinationCSV.getPeopleVaccinated());
        vaccinationSeriesDTO.setPeopleFullyVaccinated(vaccinationCSV.getPeopleFullyVaccinated());
        vaccinationSeriesDTO.setPeopleVaccinatedPerHundred(vaccinationCSV.getPeopleVaccinatedPerHundred());
        vaccinationSeriesDTO.setTotalVaccionations(vaccinationCSV.getTotalVaccionations());
        vaccinationSeriesDTO.setTotalVaccinationsPerHundred(vaccinationCSV.getTotalVaccinationsPerHundred());

        return vaccinationSeriesDTO;
    }

    public List<CountryDTO> convertLocationCSVToCountryDTO(List<LocationCSV> locationCSVList){

        List<CountryDTO> countryDTOList = locationCSVList.stream().map(locationCSV -> {
            CountryDTO countryDTO = convertLocationCSVToCountryDTO(locationCSV);
            return countryDTO;
        }).collect(Collectors.toList());

        return countryDTOList;
    }

    public Trio<List<CountryDTO>, List<VaccineDTO>, List<VaccinationSeriesDTO>> convertLocationCSVToCountryDTO(List<LocationCSV> locationCSVList, List<VaccinationCSV> vaccinationCSVList){

        //Map CountryDTO list and VaccineDTO list
        Map<String, VaccineDTO> vaccineRegister = new HashMap<>();
        Map<String, CountryDTO> countryRegister = new HashMap<>();
        List<CountryDTO> countryDTOList = locationCSVList.stream().map(locationCSV -> {
            CountryDTO countryDTO = convertLocationCSVToCountryDTO(locationCSV);
            String vaccineStr = locationCSV.getVaccines();

            if(vaccineStr != null){
                String[] vaccinesList = vaccineStr.split(", ");
                List<VaccineDTO> vaccineDTOList = Arrays.stream(vaccinesList).map(vaccineName -> {
                    VaccineDTO vaccine = vaccineRegister.get(vaccineName);
                    if(vaccine == null){
                        vaccine = new VaccineDTO();
                        vaccine.setId(vaccineRegister.size()+1);
                        vaccine.setName(vaccineName);
                        vaccineRegister.put(vaccineName, vaccine);
                    }
                    return vaccine;
                }).collect(Collectors.toList());
                countryDTO.setVaccines(vaccineDTOList);
            }

            countryDTO.setId(countryRegister.size()+1);
            countryRegister.put(countryDTO.getName(), countryDTO);

            return countryDTO;
        }).collect(Collectors.toList());

        //Map VaccinationSeriesDTO list.
        AtomicLong i = new AtomicLong();
        i.set(1);
        List<VaccinationSeriesDTO> vaccinationSeriesDTOList = vaccinationCSVList.stream().map(vaccinationCSV -> {
            VaccinationSeriesDTO vaccinationSeriesDTO = convertVaccinationsCSVToVaccionationSeriesDTO(vaccinationCSV);
            vaccinationSeriesDTO.setId(i.getAndIncrement());
            CountryDTO country = countryRegister.get(vaccinationCSV.getCountryName());
            if(country != null){
                vaccinationSeriesDTO.setCountry(country);
                /*List<VaccinationSeriesDTO> vaccinationAddedList = country.getVaccineSeries();
                if(vaccinationAddedList == null ){
                    vaccinationAddedList = new ArrayList<>();
                }
                vaccinationAddedList.add(vaccinationSeriesDTO);
                country.setVaccineSeries(vaccinationAddedList);*/
            }
            return vaccinationSeriesDTO;
        }).collect(Collectors.toList());
        Trio<List<CountryDTO>, List<VaccineDTO>, List<VaccinationSeriesDTO>> trio = new Trio(countryDTOList, new ArrayList<>(vaccineRegister.values()),vaccinationSeriesDTOList);
        return trio;
    }
}
