package com.cheaclo.userdatabase.service.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class FavouriteProductResponse {
    @Value("${favourite.product.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${favourite.product.response.user.fail}")
    @JsonIgnore
    private String userNotFoundMessage;

    @Value("${favourite.product.response.exist.fail}")
    @JsonIgnore
    private String productSavedMessage;

    @Value("${favourite.product.response.found.fail}")
    @JsonIgnore
    private String productNotFoundMessage;

    public boolean success;
    public String message;
    public List<Long> favouriteProducts;

    public FavouriteProductResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public FavouriteProductResponse userNotFound() {
        success = false;
        message = userNotFoundMessage;
        return this;
    }

    public FavouriteProductResponse productSaved() {
        success = false;
        message = productSavedMessage;
        return this;
    }

    public FavouriteProductResponse productNotFound() {
        success = false;
        message = productNotFoundMessage;
        return this;
    }
}
