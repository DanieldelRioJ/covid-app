package dh.covid.api.services;

import dh.covid.api.mappers.VaccinationSeriesMapper;
import dh.covid.api.mappers.VaccineMapper;
import dh.covid.api.models.internal.dto.VaccinationSeriesDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.repositories.VaccinationSeriesRepository;
import dh.covid.api.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationSeriesServiceImpl implements VaccinationSeriesService {

    @Autowired
    private VaccinationSeriesRepository vaccinationSeriesRepository;

    @Autowired
    private VaccinationSeriesMapper vaccinationSeriesMapper;

    @Override
    public List<VaccinationSeriesDTO> getVaccines() {
        return null;
    }

    @Override
    public void save(VaccinationSeriesDTO vaccinationSeriesDTO) {

    }

    @Override
    public List<VaccinationSeriesDTO> saveAll(List<VaccinationSeriesDTO> vaccinationSeriesDTOList) {
        List<VaccinationSeries> vaccinationSeries = vaccinationSeriesMapper.toVaccinationSeries(vaccinationSeriesDTOList);
        vaccinationSeries = vaccinationSeriesRepository.saveAll(vaccinationSeries);
        return vaccinationSeriesMapper.toVaccinationSeriesDTO(vaccinationSeries);
    }

    @Override
    public void deleteAll() {
        this.vaccinationSeriesRepository.deleteAll();
    }
}
