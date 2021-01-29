package dh.covid.api.mappers;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.dto.VaccineDTO;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.Vaccine;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccineMapper {

    VaccineDTO toVaccineDTO(Vaccine vaccine);
    List<VaccineDTO> toVaccineDTO(List<Vaccine> vaccine);
    Vaccine toVaccine(VaccineDTO vaccineDTO);
    List<Vaccine> toVaccine(List<VaccineDTO> vaccineDTOList);

}
