package com.cheaclo.userdatabase.service;

import com.cheaclo.userdatabase.entity.AccountInfo;
import com.cheaclo.userdatabase.entity.Address;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.AddUserRequestBody;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AddUserParser {
    public User requestToEntity(AddUserRequestBody request) {
        Address address = new Address(-1L,
                request.getStreet(),
                request.getStreetNumber(),
                request.getCity(),
                request.getPostalCode(),
                request.getCountry());

        AccountInfo accountInfo = new AccountInfo(-1L,
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                request.getPassword(),
                request.getBirthday(),
                request.getGender(),
                request.getPhone(),
                address);

        User user = new User(-1L, new Date(), accountInfo);
        return user;
    }
}
