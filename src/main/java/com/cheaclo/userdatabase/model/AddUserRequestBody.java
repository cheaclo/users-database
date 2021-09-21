package com.cheaclo.userdatabase.model;

import lombok.Data;

import java.util.Date;

@Data
public class AddUserRequestBody {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date birthday;
    private Gender gender;
    private String phone;
    private String street;
    private int streetNumber;
    private String city;
    private String postalCode;
    private String country;
}
