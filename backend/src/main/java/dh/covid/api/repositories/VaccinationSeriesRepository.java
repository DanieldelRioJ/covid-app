package dh.covid.api.repositories;

import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.VaccinationSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationSeriesRepository extends JpaRepository<VaccinationSeries, Integer> {
}
