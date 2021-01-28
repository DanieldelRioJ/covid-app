package dh.covid.api.repositories;

import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
}
