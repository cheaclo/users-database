package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.AddUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.AddUserParser;
import com.cheaclo.userdatabase.service.AddUserResponse;
import com.cheaclo.userdatabase.service.CountryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AddUserController {
    private final AddUserResponse addUserResponse;
    private final CountryValidator countryValidator;
    private final AddUserParser addUserParser;
    private final UserRepository userRepository;

    @PostMapping("/add")
    public AddUserResponse addUser(@Valid @RequestBody AddUserRequestBody request) {
        if (!countryValidator.validateCountry(request.getCountry()))
            return addUserResponse.noCountry();
        User checkDuplicate = userRepository.findFirstByAccountInfo_Email(request.getEmail());
        if (checkDuplicate != null)
            return addUserResponse.duplicate();

        User user = addUserParser.requestToEntity(request);
        userRepository.save(user);

        return addUserResponse.success();
    }
}
