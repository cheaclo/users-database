package com.cheaclo.userdatabase.service.response;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavouriteProductResponseTest {
    @Value("${favourite.product.response.success}")
    private String successMessage;

    @Value("${favourite.product.response.user.fail}")
    private String userNotFoundMessage;

    @Value("${favourite.product.response.exist.fail}")
    private String productSavedMessage;

    @Value("${favourite.product.response.found.fail}")
    private String productNotFoundMessage;

    @Autowired
    private FavouriteProductResponse favouriteProductResponse;

    @Test
    void successTest() {
        String message = favouriteProductResponse.success().message;
        assertEquals(successMessage, message);
    }

    @Test
    void userNotFoundTest() {
        String message = favouriteProductResponse.userNotFound().message;
        assertEquals(userNotFoundMessage, message);
    }

    @Test
    void productSavedTest() {
        String message = favouriteProductResponse.productSaved().message;
        assertEquals(productSavedMessage, message);
    }

    @Test
    void productNotFoundTest() {
        String message = favouriteProductResponse.productNotFound().message;
        assertEquals(productNotFoundMessage, message);
    }
}