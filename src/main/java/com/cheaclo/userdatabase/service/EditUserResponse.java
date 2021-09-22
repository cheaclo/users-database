package com.cheaclo.userdatabase.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EditUserResponse {
    @Value("${edit.user.email.response.success}")
    private String successMessage;

    @Value("${edit.user.email.response.fail}")
    private String userNotFoundMessage;

    public boolean success;
    public String message;

    public EditUserResponse userNotFound() {
        success = false;
        message = userNotFoundMessage;
        return this;
    }

    public EditUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }
}
