package com.cheaclo.userdatabase.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddPhraseRequestBody {
    @NotNull
    private Long userId;

    @NotNull
    private String searchedPhrase;
}
