package com.cheaclo.userdatabase.controller;

import com.cheaclo.userdatabase.model.AddUserRequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AddUserController {
    @PostMapping("/add")
    public String saveProducts(@RequestBody AddUserRequestBody request) {
        return "Success";
    }
}
