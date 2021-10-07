package com.cheaclo.userdatabase.service.response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SignInUserResponse {
    @Value("${signin.user.response.success}")
    private String successMessage;

    @Value("${signin.user.response.fail}")
    private String incorrectEmailOrPasswordMessage;

    public boolean success;
    public String message;

    public SignInUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public SignInUserResponse incorrectEmailOrPassword() {
        success = false;
        message = incorrectEmailOrPasswordMessage;
        return this;
    }
}
