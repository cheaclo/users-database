package com.cheaclo.userdatabase.service.response;

import com.cheaclo.userdatabase.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class EditUserResponse {
    @Value("${edit.user.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${edit.user.response.user.fail}")
    @JsonIgnore
    private String userNotFoundMessage;

    @Value("${edit.user.response.country.fail}")
    @JsonIgnore
    private String countryNotFoundMessage;

    @Value("${edit.user.response.json.fail}")
    @JsonIgnore
    private String invalidJsonMessage;

    public boolean success;
    public String message;
    public User user;

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
