package dh.covid.api.repositories;

import dh.covid.api.models.internal.vo.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByNameIgnoreCase(String name);

    @Query("SELECT c FROM Country c ORDER BY c.lastVaccineSeries.peopleVaccinatedPerHundred DESC NULLS LAST")
    Page<Country> findTopCountries(Pageable pageable);
}
