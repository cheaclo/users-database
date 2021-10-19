package com.cheaclo.userdatabase.service.response;

import com.cheaclo.userdatabase.entity.SavedProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SavedProductResponse {
    @Value("${saved.product.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${saved.product.response.user.fail}")
    @JsonIgnore
    private String userNotFoundMessage;

    @Value("${saved.product.response.exist.fail}")
    @JsonIgnore
    private String productSavedMessage;


    public boolean success;
    public String message;
    public List<Long> savedProducts;

    public SavedProductResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public SavedProductResponse userNotFound() {
        success = false;
        message = userNotFoundMessage;
        return this;
    }

    public SavedProductResponse productSaved() {
        success = false;
        message = productSavedMessage;
        return this;
    }
}
