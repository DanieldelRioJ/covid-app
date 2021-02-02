package dh.covid.api.mappers;

import dh.covid.api.models.internal.dto.VaccinationSeriesDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import dh.covid.api.models.internal.vo.Vaccine;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccinationSeriesMapper {

    VaccinationSeriesDTO toVaccinationSeriesDTO(VaccinationSeries vaccinationSeries);
    List<VaccinationSeriesDTO> toVaccinationSeriesDTO(List<VaccinationSeries> vaccinationSeriesList);
    VaccinationSeries toVaccinationSeries(VaccinationSeriesDTO vaccinationSeriesDTO);
    List<VaccinationSeries> toVaccinationSeries(List<VaccinationSeriesDTO> vaccinationSeriesDTOList);

}
