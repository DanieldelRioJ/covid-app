package dh.covid.api.controllers;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.external_fetchers.VaccinationsExternalFetcher;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.models.external.locations.LocationCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private VaccinationsExternalFetcher vaccinationsExternalFetcher;

    @Autowired
    private LocationsExternalFetcher locationsExternalFetcher;

    @GetMapping("/testVaccines")
    private ResponseEntity<List<VaccinationCSV>> testVaccines() throws Exception {
        return ResponseEntity.ok(vaccinationsExternalFetcher.getItems());
    }

    @GetMapping("/testLocations")
    private ResponseEntity<List<LocationCSV>> testLocation() throws Exception {
        return ResponseEntity.ok(locationsExternalFetcher.getItems());
    }

}
