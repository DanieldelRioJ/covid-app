package dh.covid.api.controllers;

import dh.covid.api.models.internal.vo.Vaccine;
import dh.covid.api.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    //Get vaccination series of a country, continent or all the world
    @GetMapping("vaccines")
    public ResponseEntity<List<Vaccine>> getVaccination(@RequestParam(required = false, name = "country") String countryISO,
                                                        @RequestParam(required = false) String continent){
        return ResponseEntity.ok(vaccineService.getVaccines());
    }

    //Get vaccination stats
    @GetMapping("vaccination/stats")
    public ResponseEntity<?> getVaccionationStats(@RequestParam String type, @RequestParam(required = false) String continent){
        return null;
    }

}
