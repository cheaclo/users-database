package com.cheaclo.userdatabase;

import com.cheaclo.userdatabase.entity.Country;
import com.cheaclo.userdatabase.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

@Component
public class InitDatabase {
    @Value("${database.init}")
    private boolean initDatabase;
    @Value("${file.country-list.path}")
    private String countryListPath;

    @Autowired
    private CountryRepository countryRepository;

    @PostConstruct
    public void postConstruct() {
        if (initDatabase)
            populateDatabase();
    }

    private void populateDatabase() {
        List<String> countries = getCountries();
        for (String country : countries) {
            countryRepository.save(new Country(-1L, country));
        }
    }

    private List<String> getCountries() {
        List<String> countries = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ResourceUtils.getFile(countryListPath)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
                countries.add(line);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
}
