package dh.covid.api.controllers;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.internal.dto.CountryDTO;
import dh.covid.api.services.CountryService;
import dh.covid.api.services.DataDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private DataDumper dataDumper;

    @GetMapping("countries")
    public ResponseEntity<?> getCountry() throws Exception {
        dataDumper.autoReload();

        List<CountryDTO> countries = countryService.getCountries();
        return ResponseEntity.ok(countries);
    }
}
