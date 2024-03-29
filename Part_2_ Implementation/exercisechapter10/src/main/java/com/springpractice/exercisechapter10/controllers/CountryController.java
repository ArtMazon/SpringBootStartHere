package com.springpractice.exercisechapter10.controllers;


import com.springpractice.exercisechapter10.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france(){
        Country france = Country.of("France",67);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("Capital","Paris")
                .body(france);
    }

    @GetMapping("/all")
    public List<Country> all(){
        Country c1 = Country.of("France",67);
        Country c2 = Country.of("Spain",72);

        return List.of(c1,c2);
    }

}
