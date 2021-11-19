package com.cheaclo.userdatabase.model.request;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SignInRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectRequestValidationTest() {
        SignInRequestBody SignInRequestBody = new SignInRequestBody();
        SignInRequestBody.setEmail("incorrect email");
        SignInRequestBody.setPassword("333");

        Set<ConstraintViolation<SignInRequestBody>> violations = validator.validate(SignInRequestBody);
        assertEquals(2, violations.size());
    }

    @Test
    public void correctRequestValidationTest() {
        SignInRequestBody SignInRequestBody = new SignInRequestBody();
        SignInRequestBody.setEmail("jack@gmail.com");
        SignInRequestBody.setPassword("55555");

        Set<ConstraintViolation<SignInRequestBody>> violations = validator.validate(SignInRequestBody);
        assertEquals(0, violations.size());
    }
}