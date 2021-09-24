package com.cheaclo.userdatabase.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryValidatorTest {
    @Autowired
    private CountryValidator countryValidator;

    private final String correctCountryOne = "France";
    private final String correctCountryTwo = "Ireland";
    private final String correctCountryThree = "Poland";
    private final String correctCountryFour = "China";
    private final String correctCountryFive = "Egypt";

    private final String incorrectCountryOne = "Fineland";
    private final String incorrectCountryTwo = "Disney Land";
    private final String incorrectCountryThree = "Some fake";
    private final String incorrectCountryFour = "Italia";
    private final String incorrectCountryFive = "Sombrero";

    @Test
    public void countryValidatorTest() {
        assertTrue(countryValidator.validateCountry(correctCountryOne));
        assertTrue(countryValidator.validateCountry(correctCountryTwo));
        assertTrue(countryValidator.validateCountry(correctCountryThree));
        assertTrue(countryValidator.validateCountry(correctCountryFour));
        assertTrue(countryValidator.validateCountry(correctCountryFive));

        assertFalse(countryValidator.validateCountry(incorrectCountryOne));
        assertFalse(countryValidator.validateCountry(incorrectCountryTwo));
        assertFalse(countryValidator.validateCountry(incorrectCountryThree));
        assertFalse(countryValidator.validateCountry(incorrectCountryFour));
        assertFalse(countryValidator.validateCountry(incorrectCountryFive));
    }
}