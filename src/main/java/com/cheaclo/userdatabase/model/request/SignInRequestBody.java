package com.cheaclo.userdatabase.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SignInRequestBody {
    @NotNull
    @Email
    private String email;

    @Size(min=5, max=30)
    private String password;
}
