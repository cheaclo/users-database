package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.AccountInfo;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.EditUserRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.EditUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/edit")
public class EditUserController {
    @Autowired
    private EditUserResponse editUserResponse;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/email")
    public EditUserResponse editUserEmail(@Valid @RequestBody EditUserRequestBody request) {
        User user = userRepository.findFirstByIdAndAccountInfo_EmailIgnoreCase(request.getUserId(), request.getEmail());
        if (user == null)
            return editUserResponse.userNotFound();

        AccountInfo accountInfo = user.getAccountInfo();
        accountInfo.setEmail(request.getNewEmail());
        user.setAccountInfo(accountInfo);
        userRepository.save(user);

        return editUserResponse.success();
    }
}
