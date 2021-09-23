package com.cheaclo.userdatabase.service;

import com.cheaclo.userdatabase.entity.AccountInfo;
import com.cheaclo.userdatabase.entity.Address;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.EditUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditUserControllerHelper {
    private final EditUserResponse editUserResponse;
    private final UserRepository userRepository;
    private final CountryValidator countryValidator;

    public ResponseEntity<EditUserResponse> editUserField(EditUserRequestBody request) {
        User user = userRepository.findFirstByIdAndAccountInfo_EmailIgnoreCase(request.getUserId(), request.getEmail());
        if (user == null)
            return ResponseEntity.badRequest().body(editUserResponse.userNotFound());

        AccountInfo accountInfo = user.getAccountInfo();

        if (request.getNewFirstname() != null)
            accountInfo.setFirstname(request.getNewFirstname());
        if (request.getNewLastname() != null)
            accountInfo.setLastname(request.getNewLastname());
        if (request.getNewEmail() != null)
            accountInfo.setEmail(request.getNewEmail());
        if (request.getNewPassword() != null)
            accountInfo.setPassword(request.getNewPassword());
        if (request.getNewGender() != null)
            accountInfo.setGender(request.getNewGender());
        if (request.getNewBirthday() != null)
            accountInfo.setBirthdayDate(request.getNewBirthday());
        if (request.getNewPhone() != null)
            accountInfo.setPhoneNumber(request.getNewPhone());

        Address address = accountInfo.getAddress();

        if (request.getNewStreet() != null)
            address.setStreet(request.getNewStreet());
        if (request.getNewStreetNumber() != null)
            address.setStreetNumber(request.getNewStreetNumber());
        if (request.getNewCity() != null)
            address.setCity(request.getNewCity());
        if (request.getNewPostalCode() != null)
            address.setPostalCode(request.getNewPostalCode());
        if (request.getNewCountry() != null) {
            if (!countryValidator.validateCountry(request.getNewCountry()))
                return ResponseEntity.badRequest().body(editUserResponse.countryNotFound());
            address.setCountry(request.getNewCountry());
        }

        accountInfo.setAddress(address);
        user.setAccountInfo(accountInfo);
        userRepository.save(user);

        return ResponseEntity.ok(editUserResponse.success());
    }
}
