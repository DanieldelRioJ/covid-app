package dh.covid.api.services;

import dh.covid.api.mappers.WorldSeriesMapper;
import dh.covid.api.models.internal.dto.WorldSeriesDTO;
import dh.covid.api.models.internal.vo.WorldSeries;
import dh.covid.api.repositories.WorldVaccinationSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldSeriesServiceImpl implements WorldSeriesService{

    @Autowired
    private WorldVaccinationSeriesRepository worldVaccinationSeriesRepository;

    @Autowired
    private WorldSeriesMapper worldSeriesMapper;

    public Page<WorldSeries> getSeries(Pageable pageable){
        return worldVaccinationSeriesRepository.findAll(pageable);
    }

    @Override
    public List<WorldSeriesDTO> saveAll(List<WorldSeriesDTO> worldSeriesDTOList) {
        List<WorldSeries> worldSeriesList = worldSeriesMapper.toWorldSeries(worldSeriesDTOList);
        worldSeriesList = worldVaccinationSeriesRepository.saveAll(worldSeriesList);
        worldSeriesDTOList = worldSeriesMapper.toWorldSeriesDTO(worldSeriesList);
        return worldSeriesDTOList;
    }

    @Override
    public void deleteAll() {
        worldVaccinationSeriesRepository.deleteAll();
    }

    @Override
    public WorldSeries getLastSerie() {
        return worldVaccinationSeriesRepository.findAll(PageRequest.of(0,1, Sort.by("date").descending())).getContent().get(0);
    }

    @Override
    public WorldSeries getYesterdayData() {
        return worldVaccinationSeriesRepository.findAll(PageRequest.of(1,1, Sort.by("date").descending())).getContent().get(0);
    }
}
