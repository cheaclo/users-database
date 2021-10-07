package com.cheaclo.userdatabase.service.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserResponse {
    @Value("${delete.user.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${delete.user.response.fail}")
    @JsonIgnore
    private String userNotFoundMessage;

    public boolean success;
    public String message;

    public DeleteUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public DeleteUserResponse userNotFound() {
        success = false;
        message = userNotFoundMessage;
        return this;
    }
}
