package com.cheaclo.userdatabase.model.request;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavouriteProductRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectRequestValidationTest() {
        FavouriteProductRequestBody favouriteProductRequestBody = new FavouriteProductRequestBody();
        favouriteProductRequestBody.setProductId(null);
        favouriteProductRequestBody.setUserId(null);

        Set<ConstraintViolation<FavouriteProductRequestBody>> violations = validator.validate(favouriteProductRequestBody);
        assertEquals(2, violations.size());
    }

    @Test
    public void correctRequestValidationTest() {
        FavouriteProductRequestBody favouriteProductRequestBody = new FavouriteProductRequestBody();
        favouriteProductRequestBody.setUserId(1L);
        favouriteProductRequestBody.setProductId(1L);

        Set<ConstraintViolation<FavouriteProductRequestBody>> violations = validator.validate(favouriteProductRequestBody);
        assertEquals(0, violations.size());
    }
}