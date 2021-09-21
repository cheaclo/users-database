package com.cheaclo.userdatabase.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

@Component
public class CountryValidator {
    @Value("${file.country-list.path}")
    private String countryListPath;

    private List<String> countries;

    @PostConstruct
    public void postConstruct() {
        countries = getCountries();
    }

    private List<String> getCountries() {
        List<String> countries = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ResourceUtils.getFile(countryListPath)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                countries.add(line.toLowerCase());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    public boolean validateCountry(String country) {
        if (!countries.contains(country.toLowerCase()))
            return false;
        return true;
    }
}
