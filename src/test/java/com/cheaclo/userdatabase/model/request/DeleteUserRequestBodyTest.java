package com.cheaclo.userdatabase.model.request;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DeleteUserRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectRequestValidationTest() {
        DeleteUserRequestBody deleteUserRequestBody = new DeleteUserRequestBody();

        Set<ConstraintViolation<DeleteUserRequestBody>> violations = validator.validate(deleteUserRequestBody);
        assertEquals(2, violations.size());

        deleteUserRequestBody.setUserId(2L);

        violations = validator.validate(deleteUserRequestBody);
        assertEquals(1, violations.size());

        deleteUserRequestBody.setEmail("incorrect@");

        violations = validator.validate(deleteUserRequestBody);
        assertEquals(1, violations.size());
    }

    @Test
    public void correctRequestValidationTest() {
        DeleteUserRequestBody deleteUserRequestBody = new DeleteUserRequestBody();
        deleteUserRequestBody.setUserId(2L);
        deleteUserRequestBody.setEmail("correct@gmail.com");

        Set<ConstraintViolation<DeleteUserRequestBody>> violations = validator.validate(deleteUserRequestBody);
        assertEquals(0, violations.size());
    }
}