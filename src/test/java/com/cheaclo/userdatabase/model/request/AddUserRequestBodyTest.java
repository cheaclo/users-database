package com.cheaclo.userdatabase.model.request;

import com.cheaclo.userdatabase.model.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddUserRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectRequestValidationTest() {
        AddUserRequestBody addUserRequestBody = new AddUserRequestBody();
        addUserRequestBody.setFirstname("a");

        Set<ConstraintViolation<AddUserRequestBody>> violations = validator.validate(addUserRequestBody);
        assertEquals(4, violations.size());

        addUserRequestBody.setLastname("lastname");
        addUserRequestBody.setEmail("last@gmail.com");
        addUserRequestBody.setPassword("password");

        violations = validator.validate(addUserRequestBody);
        assertEquals(1, violations.size());

        addUserRequestBody.setPhone("220912s");

        violations = validator.validate(addUserRequestBody);
        assertEquals(2, violations.size());

        addUserRequestBody.setStreet("2 May Camp");

        violations = validator.validate(addUserRequestBody);
        assertEquals(2, violations.size());
    }

    @Test
    public void correctRequestValidationTest() {
        AddUserRequestBody addUserRequestBody = new AddUserRequestBody();
        addUserRequestBody.setFirstname("firstname");
        addUserRequestBody.setLastname("lastname");
        addUserRequestBody.setEmail("last@gmail.com");
        addUserRequestBody.setPassword("password");
        addUserRequestBody.setBirthday(new Date());
        addUserRequestBody.setGender(Gender.MAN);
        addUserRequestBody.setPhone("999999999");
        addUserRequestBody.setStreet("2 May Camp");
        addUserRequestBody.setStreetNumber(22);
        addUserRequestBody.setCity("York");
        addUserRequestBody.setPostalCode("Y01UO8");
        addUserRequestBody.setCountry("Netherlands");

        Set<ConstraintViolation<AddUserRequestBody>> violations = validator.validate(addUserRequestBody);
        assertEquals(0, violations.size());
    }
}