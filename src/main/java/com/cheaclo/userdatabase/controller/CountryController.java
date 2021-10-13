package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.service.CountryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CountryController {
    private final CountryValidator countryValidator;

    @GetMapping("/country/all")
    public ResponseEntity<List<String>> getCountries() {
        return ResponseEntity.ok(countryValidator.getCountries());
    }
}
