package com.cheaclo.userdatabase.controller;

import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.SignInRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.SignInUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class SignInUserController {
    private UserRepository userRepository;
    private SignInUserResponse signInUserResponse;

    @PostMapping("/sign-in")
    public ResponseEntity<SignInUserResponse> signIn(@Valid @RequestBody SignInRequestBody request) {
        User user = userRepository.findFirstByAccountInfo_EmailIgnoreCase(request.getEmail());
        if (user == null || !user.getAccountInfo().getPassword().equals(request.getPassword()))
            return ResponseEntity.ok(signInUserResponse.incorrectEmailOrPassword());

        signInUserResponse.setUser(user);
        return ResponseEntity.ok(signInUserResponse.success());
    }
}
