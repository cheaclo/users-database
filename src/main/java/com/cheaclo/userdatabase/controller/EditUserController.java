package com.cheaclo.userdatabase.controller;

import com.cheaclo.userdatabase.model.request.EditUserRequestBody;
import com.cheaclo.userdatabase.service.EditUserControllerHelper;
import com.cheaclo.userdatabase.service.response.EditUserResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/edit")
public class EditUserController {
    private final EditUserControllerHelper editUserControllerHelper;
    
    @PostMapping("/firstname")
    public ResponseEntity<EditUserResponse> editUserFirstname(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/lastname")
    public ResponseEntity<EditUserResponse> editUserLastname(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/email")
    public ResponseEntity<EditUserResponse> editUserEmail(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/password")
    public ResponseEntity<EditUserResponse> editUserPassowrd(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/gender")
    public ResponseEntity<EditUserResponse> editUserGender(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/birthday")
    public ResponseEntity<EditUserResponse> editUserBirthday(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/street")
    public ResponseEntity<EditUserResponse> editUserStreet(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/street_number")
    public ResponseEntity<EditUserResponse> editUserStreetName(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/city")
    public ResponseEntity<EditUserResponse> editUserCity(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/postal_code")
    public ResponseEntity<EditUserResponse> editUserPostalCode(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/country")
    public ResponseEntity<EditUserResponse> editUserCountry(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }

    @PostMapping("/phone")
    public ResponseEntity<EditUserResponse> editUserPhone(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }
}
