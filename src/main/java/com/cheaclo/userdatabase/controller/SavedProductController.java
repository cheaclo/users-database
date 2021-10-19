package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.SavedProduct;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.AddUserRequestBody;
import com.cheaclo.userdatabase.model.request.SavedProductRequestBody;
import com.cheaclo.userdatabase.repository.SavedProductRepository;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.AddUserParser;
import com.cheaclo.userdatabase.service.CountryValidator;
import com.cheaclo.userdatabase.service.response.AddUserResponse;
import com.cheaclo.userdatabase.service.response.SavedProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/saved-product")
public class SavedProductController {
    private final SavedProductResponse savedProductResponse;
    private final UserRepository userRepository;
    private final SavedProductRepository savedProductRepository;

    @PostMapping("/add")
    public ResponseEntity<SavedProductResponse> addSavedProduct(@Valid @RequestBody SavedProductRequestBody request) {
        User user = userRepository.findFirstById(request.getUserId());
        if (user == null)
            return ResponseEntity.ok(savedProductResponse.userNotFound());

        SavedProduct savedProduct = savedProductRepository.findFirstByUserAndProduct(user, request.getProductId());
        if (savedProduct != null)
            return ResponseEntity.ok(savedProductResponse.productSaved());

        savedProductRepository.save(new SavedProduct(-1L, user, request.getProductId()));

        return ResponseEntity.ok(savedProductResponse.success());
    }
}
