package dh.covid.api.services;

import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.models.internal.dto.WorldSeriesDTO;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.WorldSeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorldSeriesService {

    Page<WorldSeries> getSeries(Pageable pageable);
    List<WorldSeriesDTO> saveAll(List<WorldSeriesDTO> worldSeriesDTOList);

    void deleteAll();

    WorldSeries getLastSerie();
}
