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
class EditUserRequestBodyTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void incorrectRequestValidationTest() {
        EditUserRequestBody addUserRequestBody = new EditUserRequestBody();

        Set<ConstraintViolation<EditUserRequestBody>> violations = validator.validate(addUserRequestBody);
        assertEquals(2, violations.size());

        addUserRequestBody.setNewFirstname("a");
        addUserRequestBody.setNewLastname("lastname");
        addUserRequestBody.setNewEmail("last@gmail.com");
        addUserRequestBody.setNewPassword("password");

        violations = validator.validate(addUserRequestBody);
        assertEquals(3, violations.size());

        addUserRequestBody.setUserId(2L);
        addUserRequestBody.setEmail("correct@gmail.com");

        violations = validator.validate(addUserRequestBody);
        assertEquals(1, violations.size());


        addUserRequestBody.setNewPhone("220912s");

        violations = validator.validate(addUserRequestBody);
        assertEquals(2, violations.size());

        addUserRequestBody.setNewStreet("2 May Camp");

        violations = validator.validate(addUserRequestBody);
        assertEquals(2, violations.size());
    }

    @Test
    public void correctRequestValidationTest() {
        EditUserRequestBody editUserRequestBody = new EditUserRequestBody();
        editUserRequestBody.setUserId(1L);
        editUserRequestBody.setEmail("correct@gmail.com");
        editUserRequestBody.setNewFirstname("firstname");
        editUserRequestBody.setNewLastname("lastname");
        editUserRequestBody.setNewEmail("correct@gmail.com");
        editUserRequestBody.setNewPassword("password");
        editUserRequestBody.setNewBirthday(new Date());
        editUserRequestBody.setNewGender(Gender.MAN);
        editUserRequestBody.setNewPhone("999999999");
        editUserRequestBody.setNewStreet("2 May Camp");
        editUserRequestBody.setNewStreetNumber(22);
        editUserRequestBody.setNewCity("York");
        editUserRequestBody.setNewPostalCode("Y01UO8");
        editUserRequestBody.setNewCountry("Netherlands");
    }
}