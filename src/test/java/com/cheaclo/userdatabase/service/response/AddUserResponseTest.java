package com.cheaclo.userdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddUserResponseTest {
    @Value("${add.user.response.success}")
    private String successMessage;

    @Value("${add.user.response.fail.country}")
    private String invalidCountryMessage;

    @Value("${add.user.response.fail.duplicate}")
    private String duplicateMessage;

    @Autowired
    private AddUserResponse addUserResponse;

    @Test
    void invalidCountryTest() {
        String message = addUserResponse.invalidCountry().message;
        assertEquals(invalidCountryMessage, message);
    }

    @Test
    void successTest() {
        String message = addUserResponse.success().message;
        assertEquals(successMessage, message);
    }

    @Test
    void duplicateTest() {
        String message = addUserResponse.duplicate().message;
        assertEquals(duplicateMessage, message);
    }
}