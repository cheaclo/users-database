package com.cheaclo.userdatabase.service.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EditUserResponse {
    @Value("${edit.user.response.success}")
    private String successMessage;

    @Value("${edit.user.response.user.fail}")
    private String userNotFoundMessage;

    @Value("${edit.user.response.country.fail}")
    private String countryNotFoundMessage;

    @Value("${edit.user.response.json.fail}")
    private String invalidJsonMessage;

    public boolean success;
    public String message;

    public EditUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public EditUserResponse userNotFound() {
        success = false;
        message = userNotFoundMessage;
        return this;
    }

    public EditUserResponse countryNotFound() {
        success = false;
        message = countryNotFoundMessage;
        return this;
    }

    public EditUserResponse invalidJson() {
        success = false;
        message = invalidJsonMessage;
        return this;
    }
}
