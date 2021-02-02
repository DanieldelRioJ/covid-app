package dh.covid.api.services;

import dh.covid.api.models.internal.dto.VaccinationSeriesDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;

import java.util.List;

public interface VaccinationSeriesService {

    List<VaccinationSeriesDTO> getVaccines();
    void save(VaccinationSeriesDTO country);
    List<VaccinationSeriesDTO> saveAll(List<VaccinationSeriesDTO> vaccineDTOList);
    void deleteAll();
}
