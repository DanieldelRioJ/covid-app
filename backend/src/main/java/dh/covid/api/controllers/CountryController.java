package dh.covid.api.controllers;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.services.CountryService;
import dh.covid.api.services.DataDumper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private DataDumper dataDumper;

    @GetMapping("countries")
    public ResponseEntity<List<Country>> getCountries() throws Exception {
        List<Country> countries = countryService.getCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("countries/{identifier}")
    public ResponseEntity<Country> getCountry(@PathVariable String identifier) throws Exception {
        Country country = null;
        try{
            Integer id = Integer.valueOf(identifier);
            country = countryService.getCountryById(id);
        }catch (NumberFormatException nfe){

        }
        return country != null? ResponseEntity.ok(country): ResponseEntity.notFound().build();
    }
}
