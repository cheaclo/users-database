package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.AddUserRequestBody;
import com.cheaclo.userdatabase.service.AddUserParser;
import com.cheaclo.userdatabase.service.CountryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class AddUserController {
    @Autowired
    private CountryValidator countryValidator;

    @Autowired
    private AddUserParser addUserParser;
    @PostMapping("/add")
    public String saveProducts(@Valid @RequestBody AddUserRequestBody request) {
        if (!countryValidator.validateCountry(request.getCountry()))
            return "Fail";

        User user = addUserParser.requestToEntity(request);

        return "Success";
    }
}
