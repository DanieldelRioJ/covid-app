package dh.covid.api.services;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.Vaccine;

import java.util.List;

public interface VaccineService {

    List<VaccineDTO> getVaccines();
    VaccineDTO getVaccineById(Integer id);
    void save(VaccineDTO country);
    List<VaccineDTO> saveAll(List<VaccineDTO> vaccineDTOList);
    void deleteAll();
}
