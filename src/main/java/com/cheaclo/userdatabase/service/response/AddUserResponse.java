package com.cheaclo.userdatabase.service.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddUserResponse {
    @Value("${add.user.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${add.user.response.fail.country}")
    @JsonIgnore
    private String noCountryMessage;

    @Value("${add.user.response.fail.duplicate}")
    @JsonIgnore
    private String duplicateMessage;

    public boolean success;
    public String message;

    public AddUserResponse invalidCountry() {
        success = false;
        message = noCountryMessage;
        return this;
    }

    public AddUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public AddUserResponse duplicate() {
        success = false;
        message = duplicateMessage;
        return this;
    }
}
