package dh.covid.api.services;

import dh.covid.api.mappers.VaccineMapper;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    private VaccineMapper vaccineMapper;


    @Override
    public List<Vaccine> getVaccines() {
        return vaccineRepository.findAll();
    }

    @Override
    public VaccineDTO getVaccineById(Integer id) {
        return null;
    }

    @Override
    public void save(VaccineDTO country) {

    }

    @Override
    public List<VaccineDTO> saveAll(List<VaccineDTO> vaccineDTOList) {
        List<Vaccine> vaccineList = vaccineMapper.toVaccine(vaccineDTOList);
        vaccineList = vaccineRepository.saveAll(vaccineList);
        vaccineDTOList = vaccineMapper.toVaccineDTO(vaccineList);
        return vaccineDTOList;
    }

    @Override
    public void deleteAll() {
        this.vaccineRepository.deleteAll();
    }
}
