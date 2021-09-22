package com.cheaclo.userdatabase.model;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class EditUserRequestBody {
    private Long userId;
    @Email
    private String email;
    @Email
    private String newEmail;
}
