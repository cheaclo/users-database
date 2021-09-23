package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.DeleteUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.DeleteUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class DeleteUserController {
    private final UserRepository userRepository;
    private final DeleteUserResponse deleteUserResponse;

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteUserResponse> deleteUser(@Valid @RequestBody DeleteUserRequestBody request) {
        User user = userRepository.findFirstByIdAndAccountInfo_EmailIgnoreCase(request.getUserId(), request.getEmail());
        if (user == null)
            return ResponseEntity.badRequest().body(deleteUserResponse.userNotFound());

        userRepository.delete(user);

        return ResponseEntity.ok(deleteUserResponse.success());
    }
}
