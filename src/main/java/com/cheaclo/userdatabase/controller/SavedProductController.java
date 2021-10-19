package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.SavedProduct;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.SavedProductRequestBody;
import com.cheaclo.userdatabase.repository.SavedProductRepository;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.SavedProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        savedProductResponse.setSavedProducts(null);

        return ResponseEntity.ok(savedProductResponse.success());
    }

    @GetMapping("/get")
    public ResponseEntity<SavedProductResponse> getSavedProducts(@RequestParam Long id) {
        User user = userRepository.findFirstById(id);
        if (user == null)
            return ResponseEntity.ok(savedProductResponse.userNotFound());

        List<Long> savedProducts = savedProductRepository.findAllByUserId(id);
        savedProductResponse.setSavedProducts(savedProducts);

        return ResponseEntity.ok(savedProductResponse.success());
    }
}
