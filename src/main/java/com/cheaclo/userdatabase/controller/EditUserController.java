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
@RequestMapping("/user")
public class EditUserController {
    private final EditUserControllerHelper editUserControllerHelper;

    @PutMapping("/edit")
    public ResponseEntity<EditUserResponse> editUser(@Valid @RequestBody EditUserRequestBody request) {
        return editUserControllerHelper.editUserField(request);
    }
}
