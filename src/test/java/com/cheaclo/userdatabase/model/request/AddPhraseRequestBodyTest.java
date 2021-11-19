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
class AddPhraseRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectRequestValidationTest() {
        AddPhraseRequestBody addPhraseRequestBody = new AddPhraseRequestBody();
        addPhraseRequestBody.setSearchedPhrase(null);
        addPhraseRequestBody.setUserId(null);

        Set<ConstraintViolation<AddPhraseRequestBody>> violations = validator.validate(addPhraseRequestBody);
        assertEquals(2, violations.size());
    }

    @Test
    public void correctRequestValidationTest() {
        AddPhraseRequestBody addPhraseRequestBody = new AddPhraseRequestBody();
        addPhraseRequestBody.setUserId(1L);
        addPhraseRequestBody.setSearchedPhrase("searched");

        Set<ConstraintViolation<AddPhraseRequestBody>> violations = validator.validate(addPhraseRequestBody);
        assertEquals(0, violations.size());
    }
}