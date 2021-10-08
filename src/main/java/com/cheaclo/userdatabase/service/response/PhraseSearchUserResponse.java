package com.cheaclo.userdatabase.service.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class PhraseSearchUserResponse {
    @Value("${phrase.search.add.response.success}")
    @JsonIgnore
    private String successMessage;

    @Value("${phrase.search.add.response.user.notfound}")
    @JsonIgnore
    private String userNotFoundMessage;

    public boolean success;
    public String message;

    public PhraseSearchUserResponse success() {
        success = true;
        message = successMessage;
        return this;
    }

    public PhraseSearchUserResponse userNotFound() {
        success = false;
        message = userNotFoundMessage;
        return this;
    }
}
