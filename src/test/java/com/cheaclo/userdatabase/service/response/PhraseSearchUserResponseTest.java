package com.cheaclo.userdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhraseSearchUserResponseTest {
    @Value("${phrase.search.add.response.success}")
    private String successMessage;

    @Value("${phrase.search.add.response.user.notfound}")
    private String userNotFoundMessage;

    @Autowired
    private PhraseSearchUserResponse phraseSearchUserResponse;

    @Test
    void successTest() {
        String message = phraseSearchUserResponse.success().message;
        assertEquals(successMessage, message);
    }

    @Test
    void userNotFoundTest() {
        String message = phraseSearchUserResponse.userNotFound().message;
        assertEquals(userNotFoundMessage, message);
    }
}