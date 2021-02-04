package dh.covid.api.repositories;

import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.WorldSeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldVaccinationSeriesRepository extends JpaRepository<WorldSeries, Integer> {
}
