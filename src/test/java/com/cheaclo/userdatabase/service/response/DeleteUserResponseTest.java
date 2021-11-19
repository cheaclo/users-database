package com.cheaclo.userdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeleteUserResponseTest {
    @Value("${delete.user.response.success}")
    private String successMessage;

    @Value("${delete.user.response.fail}")
    private String userNotFoundMessage;

    @Autowired
    private DeleteUserResponse deleteUserResponse;

    @Test
    void Test() {
        String message = deleteUserResponse.success().message;
        assertEquals(successMessage, message);
    }

    @Test
    void userNotFoundTest() {
        String message = deleteUserResponse.userNotFound().message;
        assertEquals(userNotFoundMessage, message);
    }
}