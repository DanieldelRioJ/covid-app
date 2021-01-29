package dh.covid.api.controllers;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.external_fetchers.VaccinationsExternalFetcher;
import dh.covid.api.models.external.vaccinations.VaccinationCSV;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.services.DataDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private DataDumper dataDumper;

    @GetMapping("/reload")
    private ResponseEntity<?> testVaccines() throws Exception {

        dataDumper.autoReload();

        return ResponseEntity.ok("");
    }

}
