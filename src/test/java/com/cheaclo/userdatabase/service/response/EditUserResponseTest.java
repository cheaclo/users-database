package com.cheaclo.userdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EditUserResponseTest {
    @Value("${edit.user.response.success}")
    private String successMessage;

    @Value("${edit.user.response.user.fail}")
    private String userNotFoundMessage;

    @Value("${edit.user.response.country.fail}")
    private String countryNotFoundMessage;

    @Value("${edit.user.response.json.fail}")
    private String invalidJsonMessage;

    @Autowired
    private EditUserResponse editUserResponse;

    @Test
    void successTest() {
        String message = editUserResponse.success().message;
        assertEquals(successMessage, message);
    }

    @Test
    void userNotFoundTest() {
        String message = editUserResponse.userNotFound().message;
        assertEquals(userNotFoundMessage, message);
    }

    @Test
    void countryNotFoundTest() {
        String message = editUserResponse.countryNotFound().message;
        assertEquals(countryNotFoundMessage, message);
    }

    @Test
    void invalidJsonTest() {
        String message = editUserResponse.invalidJson().message;
        assertEquals(invalidJsonMessage, message);
    }
}