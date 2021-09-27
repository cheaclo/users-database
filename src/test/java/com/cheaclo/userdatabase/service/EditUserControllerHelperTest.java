package com.cheaclo.userdatabase.service;

import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.Gender;
import com.cheaclo.userdatabase.model.request.EditUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.EditUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EditUserControllerHelperTest {
    @Autowired
    private EditUserControllerHelper editUserControllerHelper;

    @Autowired
    private UserRepository userRepository;

    private final int statusOk = 200;
    private final int statusBadRequest = 400;
    private final String firstEmail = "third@gmail.com";
    private final String secondEmail = "forth@gmail.com";
    private final Long firstId = 3L;
    private final Long secondId = 4L;
    private final String newPhone = "444333222";
    private final Gender newGender = Gender.OTHER;
    private final String invalidCountry = "Invalid country";
    private final String newCountry = "United States";
    private final String oldCountry = "Poland";
    private final String newEmail = "new@gmail.com";

    @Test
    void editUserPhone() {
        EditUserRequestBody editUserRequestBody = initEditUserRequestBody();
        editUserRequestBody.setNewPhone(newPhone);

        ResponseEntity<EditUserResponse> responseEntity = editUserControllerHelper.editUserField(editUserRequestBody);
        assertEquals(statusOk, responseEntity.getStatusCodeValue());

        User user = userRepository.findFirstByAccountInfo_Email(firstEmail);
        assertEquals(newPhone, user.getAccountInfo().getPhone());
    }

    @Test
    void editUserGender() {
        EditUserRequestBody editUserRequestBody = initEditUserRequestBody();
        editUserRequestBody.setNewGender(Gender.OTHER);

        ResponseEntity<EditUserResponse> responseEntity = editUserControllerHelper.editUserField(editUserRequestBody);
        assertEquals(statusOk, responseEntity.getStatusCodeValue());

        User user = userRepository.findFirstByAccountInfo_Email(firstEmail);
        assertEquals(newGender, user.getAccountInfo().getGender());
    }

    @Test
    void editUserCountry() {
        EditUserRequestBody editUserRequestBody = initEditUserRequestBody();
        editUserRequestBody.setNewCountry(invalidCountry);

        ResponseEntity<EditUserResponse> responseEntity = editUserControllerHelper.editUserField(editUserRequestBody);
        assertEquals(statusBadRequest, responseEntity.getStatusCodeValue());

        User user = userRepository.findFirstByAccountInfo_Email(firstEmail);
        assertEquals(oldCountry, user.getAccountInfo().getAddress().getCountry());

        editUserRequestBody.setNewCountry(newCountry);

        responseEntity = editUserControllerHelper.editUserField(editUserRequestBody);
        assertEquals(statusOk, responseEntity.getStatusCodeValue());

        user = userRepository.findFirstByAccountInfo_Email(firstEmail);
        assertEquals(newCountry, user.getAccountInfo().getAddress().getCountry());
    }

    @Test
    public void editUserMail() {
        EditUserRequestBody editUserRequestBody = new EditUserRequestBody();
        editUserRequestBody.setUserId(secondId);
        editUserRequestBody.setEmail(secondEmail);
        editUserRequestBody.setNewEmail(newEmail);

        ResponseEntity<EditUserResponse> responseEntity = editUserControllerHelper.editUserField(editUserRequestBody);
        assertEquals(statusOk, responseEntity.getStatusCodeValue());

        User user = userRepository.findFirstByAccountInfo_Email(newEmail);
        assertEquals(newEmail, user.getAccountInfo().getEmail());
    }

    private EditUserRequestBody initEditUserRequestBody() {
        EditUserRequestBody editUserRequestBody = new EditUserRequestBody();
        editUserRequestBody.setUserId(firstId);
        editUserRequestBody.setEmail(firstEmail);
        return  editUserRequestBody;
    }
}