package com.cheaclo.userdatabase.service;

import com.cheaclo.userdatabase.entity.AccountInfo;
import com.cheaclo.userdatabase.entity.Address;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.EditUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.EditUserResponse;
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
        Address address = accountInfo.getAddress();

        if (request.getNewFirstname() != null)
            accountInfo.setFirstname(request.getNewFirstname());
        else if (request.getNewLastname() != null)
            accountInfo.setLastname(request.getNewLastname());
        else if (request.getNewEmail() != null)
            accountInfo.setEmail(request.getNewEmail());
        else if (request.getNewPassword() != null)
            accountInfo.setPassword(request.getNewPassword());
        else if (request.getNewGender() != null)
            accountInfo.setGender(request.getNewGender());
        else if (request.getNewBirthday() != null)
            accountInfo.setBirthdayDate(request.getNewBirthday());
        else if (request.getNewPhone() != null)
            accountInfo.setPhone(request.getNewPhone());
        else if (request.getNewStreet() != null)
            address.setStreet(request.getNewStreet());
        else if (request.getNewStreetNumber() != null)
            address.setStreetNumber(request.getNewStreetNumber());
        else if (request.getNewCity() != null)
            address.setCity(request.getNewCity());
        else if (request.getNewPostalCode() != null)
            address.setPostalCode(request.getNewPostalCode());
        else if (request.getNewCountry() != null) {
            if (!countryValidator.validateCountry(request.getNewCountry()))
                return ResponseEntity.badRequest().body(editUserResponse.countryNotFound());
            address.setCountry(request.getNewCountry());
        }
        else {
            return ResponseEntity.badRequest().body(editUserResponse.invalidJson());
        }

        accountInfo.setAddress(address);
        user.setAccountInfo(accountInfo);
        userRepository.save(user);

        return ResponseEntity.ok(editUserResponse.success());
    }
}
