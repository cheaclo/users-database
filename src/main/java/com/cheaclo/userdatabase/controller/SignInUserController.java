package com.cheaclo.userdatabase.controller;

import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.SignInRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.SignInUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class SignInUserController {
    private UserRepository userRepository;
    private SignInUserResponse signInUserResponse;

    @GetMapping("/sign-in")
    public ResponseEntity<SignInUserResponse> signIn(@Valid @RequestBody SignInRequestBody request) {
        User user = userRepository.findFirstByAccountInfo_EmailIgnoreCase(request.getEmail());
        if (user == null || !user.getAccountInfo().getPassword().equals(request.getPassword()))
            return ResponseEntity.badRequest().body(signInUserResponse.incorrectEmailOrPassword());

        return ResponseEntity.ok(signInUserResponse.success());
    }
}
