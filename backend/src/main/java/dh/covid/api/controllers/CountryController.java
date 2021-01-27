package dh.covid.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class CountryController {

    @GetMapping("countries")
    public ResponseEntity<?> getCountry(){
        return null;
    }
}
