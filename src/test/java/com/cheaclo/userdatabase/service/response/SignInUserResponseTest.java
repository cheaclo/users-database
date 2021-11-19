package com.cheaclo.userdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SignInUserResponseTest {
    @Value("${signin.user.response.success}")
    private String successMessage;

    @Value("${signin.user.response.fail}")
    private String incorrectEmailOrPasswordMessage;

    @Autowired
    private SignInUserResponse signInUserResponse;

    @Test
    public void successTest() {
        String message = signInUserResponse.success().message;
        assertEquals(successMessage, message);
    }

    @Test
    public void incorrectEmailOrPasswordTest() {
        String message = signInUserResponse.incorrectEmailOrPassword().message;
        assertEquals(incorrectEmailOrPasswordMessage, message);
    }
}