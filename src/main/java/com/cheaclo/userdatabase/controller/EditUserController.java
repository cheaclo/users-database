package com.cheaclo.userdatabase.controller;

import com.cheaclo.userdatabase.model.request.EditUserRequestBody;
import com.cheaclo.userdatabase.service.EditUserControllerHelper;
import com.cheaclo.userdatabase.service.response.EditUserResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/edit")
public class EditUserController {
    private final EditUserControllerHelper editUserControllerHelper;
    
    @PutMapping("/firstname")
    public ResponseEntity<EditUserResponse> editUserFirstname(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/lastname")
    public ResponseEntity<EditUserResponse> editUserLastname(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/email")
    public ResponseEntity<EditUserResponse> editUserEmail(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/password")
    public ResponseEntity<EditUserResponse> editUserPassowrd(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/gender")
    public ResponseEntity<EditUserResponse> editUserGender(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/birthday")
    public ResponseEntity<EditUserResponse> editUserBirthday(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/street")
    public ResponseEntity<EditUserResponse> editUserStreet(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/street_number")
    public ResponseEntity<EditUserResponse> editUserStreetName(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/city")
    public ResponseEntity<EditUserResponse> editUserCity(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/postal_code")
    public ResponseEntity<EditUserResponse> editUserPostalCode(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/country")
    public ResponseEntity<EditUserResponse> editUserCountry(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PutMapping("/phone")
    public ResponseEntity<EditUserResponse> editUserPhone(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }
}
