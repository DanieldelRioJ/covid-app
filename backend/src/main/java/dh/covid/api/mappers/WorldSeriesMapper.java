package dh.covid.api.mappers;

import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.dto.WorldSeriesDTO;
import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.models.internal.vo.WorldSeries;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorldSeriesMapper {

    WorldSeriesDTO toWorldSeriesDTO(WorldSeries worldSeries);
    List<WorldSeriesDTO> toWorldSeriesDTO(List<WorldSeries> vaccine);
    WorldSeries toWorldSeries(WorldSeriesDTO worldSeriesDTO);
    List<WorldSeries> toWorldSeries(List<WorldSeriesDTO> vaccineDTOList);

}
