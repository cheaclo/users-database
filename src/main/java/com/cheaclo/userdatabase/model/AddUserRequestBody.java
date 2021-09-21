package com.cheaclo.userdatabase.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class AddUserRequestBody {
    @NotNull
    @Size(min=2, max=30)
    private String firstname;

    @NotNull
    @Size(min=2, max=30)
    private String lastname;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=5, max=30)
    private String password;

    private Date birthday;

    private Gender gender;

    @Pattern(regexp = "^\\d{9}$")
    private String phone;

    @Size(min=2, max=50)
    @Pattern(regexp = "^\\w+[\\s*\\w*]*$")
    private String street;

    @Min(1)
    @Max(99999)
    private int streetNumber;
    @Size(min=2, max=50)
    @Pattern(regexp = "^\\w+[\\s*\\w*]*$")
    private String city;
    @Pattern(regexp = "^\\w{6}$")
    private String postalCode;

    @Size(min=2, max=50)
    private String country;
}
