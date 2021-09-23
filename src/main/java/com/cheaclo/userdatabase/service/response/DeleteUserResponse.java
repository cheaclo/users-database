package com.cheaclo.userdatabase.service.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserResponse {
    @Value("${delete.user.response.success}")
    private String successMessage;

    @Value("${delete.user.response.fail}")
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
