package dh.covid.api.controllers;

import dh.covid.api.external_fetchers.LocationsExternalFetcher;
import dh.covid.api.models.external.locations.LocationCSV;
import dh.covid.api.models.internal.vo.Country;
import dh.covid.api.models.internal.vo.WorldSeries;
import dh.covid.api.services.CountryService;
import dh.covid.api.services.DataDumper;
import dh.covid.api.services.WorldSeriesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private WorldSeriesService worldSeriesService;

    @GetMapping("countries")
    public ResponseEntity<Page<Country>> getCountries(
            Pageable pageable,
            @RequestParam(required = false) Integer top
    ) throws Exception {
        Page<Country> countries;
        if(top != null){
            countries = countryService.getTopCountries(top, pageable);
        }else{
            countries = countryService.getCountries(pageable);
        }
        return ResponseEntity.ok(countries);
    }

    @GetMapping("countries/{identifier}")
    public ResponseEntity<Country> getCountry(@ApiParam("Id or name of the country") @PathVariable String identifier,
                                              @RequestParam String orderBy, @RequestParam Integer limit) throws Exception {
        Country country = null;
        try{
            Integer id = Integer.valueOf(identifier);
            country = countryService.getCountryById(id);
        }catch (NumberFormatException nfe){
            country = countryService.getCountryByName(identifier);
        }
        return country != null? ResponseEntity.ok(country): ResponseEntity.notFound().build();
    }

    @GetMapping("world")
    @ApiOperation("Data of the world vaccination series")
    public ResponseEntity<Page<WorldSeries>> getWorldSeries(Pageable pageable){

        return ResponseEntity.ok(this.worldSeriesService.getSeries(pageable));
    }

    @GetMapping("world/now")
    @ApiOperation("Get last data of the world vaccination series")
    public ResponseEntity<WorldSeries> getWorldLastSeries(){

        return ResponseEntity.ok(this.worldSeriesService.getLastSerie());
    }
}
