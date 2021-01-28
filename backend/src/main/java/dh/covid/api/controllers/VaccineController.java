package dh.covid.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VaccineController {

    //Get vaccination series of a country, continent or all the world
    @GetMapping("vaccination")
    public ResponseEntity<?> getVaccination(@RequestParam(required = false, name = "country") String countryISO,
                                             @RequestParam(required = false) String continent){
        return null;
    }

    //Get vaccination stats
    @GetMapping("vaccination/stats")
    public ResponseEntity<?> getVaccionationStats(@RequestParam String type, @RequestParam(required = false) String continent){
        return null;
    }

}
