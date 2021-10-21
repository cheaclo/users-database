package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.DeleteUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.DeleteUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class DeleteUserController {
    private final UserRepository userRepository;
    private final DeleteUserResponse deleteUserResponse;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable("id") Long id) {
        User user = userRepository.findFirstById(id);
        if (user == null)
            return ResponseEntity.badRequest().body(deleteUserResponse.userNotFound());

        userRepository.delete(user);

        return ResponseEntity.ok(deleteUserResponse.success());
    }
}
