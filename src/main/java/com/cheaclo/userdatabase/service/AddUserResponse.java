package com.cheaclo.userdatabase.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddUserResponse {
    @Value("${add.user.response.success}")
    private String successMessage;

    @Value("${add.user.response.fail.country}")
    private String noCountryMessage;

    public boolean success;
    public String message;

    public AddUserResponse noCountry() {
        success = false;
        message = noCountryMessage;
        return this;
    }

    public AddUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }
}
