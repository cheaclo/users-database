package com.cheaclo.userdatabase.service.response;

import com.cheaclo.userdatabase.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class SignInUserResponse {
    @Value("${signin.user.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${signin.user.response.fail}")
    @JsonIgnore
    private String incorrectEmailOrPasswordMessage;

    public boolean success;
    public String message;
    public User user;

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
