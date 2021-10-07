package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.AddUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.AddUserParser;
import com.cheaclo.userdatabase.service.CountryValidator;
import com.cheaclo.userdatabase.service.response.AddUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<AddUserResponse> addUser(@Valid @RequestBody AddUserRequestBody request) {
        if (!countryValidator.validateCountry(request.getCountry()))
            return ResponseEntity.badRequest().body(addUserResponse.invalidCountry());
        User checkDuplicate = userRepository.findFirstByAccountInfo_EmailIgnoreCase(request.getEmail());
        if (checkDuplicate != null)
            return ResponseEntity.badRequest().body(addUserResponse.duplicate());

        User user = addUserParser.requestToEntity(request);
        userRepository.save(user);

        return ResponseEntity.ok(addUserResponse.success());
    }
}
