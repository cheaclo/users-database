package com.cheaclo.userdatabase.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class EditUserRequestBody {
    @NotNull
    private Long userId;

    @NotNull
    @Email
    private String email;

    @Size(min=5, max=30)
    private String newFirstname;

    @Size(min=5, max=30)
    private String newLastname;

    @Email
    private String newEmail;

    @Size(min=5, max=30)
    private String newPassword;

    private Gender newGender;

    private Date newBirthday;

    @Size(min=2, max=50)
    @Pattern(regexp = "^\\w+[\\s*\\w*]*$")
    private String newStreet;

    @Min(1)
    @Max(99999)
    private Integer newStreetNumber;

    @Size(min=2, max=50)
    @Pattern(regexp = "^\\w+[\\s*\\w*]*$")
    private String newCity;

    @Pattern(regexp = "^\\w{6}$")
    private String newPostalCode;

    private String newCountry;

    @Pattern(regexp = "^\\d{9}$")
    private String newPhone;
}
