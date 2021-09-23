package com.cheaclo.userdatabase.model.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class DeleteUserRequestBody {
    @NotNull
    private Long userId;

    @NotNull
    @Email
    private String email;
}
