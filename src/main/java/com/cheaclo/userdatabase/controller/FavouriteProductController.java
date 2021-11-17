package com.cheaclo.userdatabase.controller;


import com.cheaclo.userdatabase.entity.FavouriteProduct;
import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.model.request.FavouriteProductRequestBody;
import com.cheaclo.userdatabase.repository.FavouriteProductRepository;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.service.response.FavouriteProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/favourite-product")
public class FavouriteProductController {
    private final FavouriteProductResponse favouriteProductResponse;
    private final UserRepository userRepository;
    private final FavouriteProductRepository favouriteProductRepository;

    @PostMapping("/add")
    public ResponseEntity<FavouriteProductResponse> addFavouriteProduct(@Valid @RequestBody FavouriteProductRequestBody request) {
        User user = userRepository.findFirstById(request.getUserId());
        if (user == null)
            return ResponseEntity.ok(favouriteProductResponse.userNotFound());

        FavouriteProduct favouriteProduct = favouriteProductRepository.findFirstByUserAndProduct(user, request.getProductId());
        if (favouriteProduct != null)
            return ResponseEntity.ok(favouriteProductResponse.productSaved());

        favouriteProductRepository.save(new FavouriteProduct(-1L, user, request.getProductId()));
        favouriteProductResponse.setFavouriteProducts(null);

        return ResponseEntity.ok(favouriteProductResponse.success());
    }

    @GetMapping("/get")
    public ResponseEntity<FavouriteProductResponse> getFavouriteProducts(@RequestParam Long id) {
        User user = userRepository.findFirstById(id);
        if (user == null)
            return ResponseEntity.ok(favouriteProductResponse.userNotFound());

        List<Long> favouriteProduct = favouriteProductRepository.findAllByUserId(id);
        favouriteProductResponse.setFavouriteProducts(favouriteProduct);

        return ResponseEntity.ok(favouriteProductResponse.success());
    }

    @Transactional
    @DeleteMapping("/delete/id")
    public void deleteProductById(@RequestParam Long id) {
        favouriteProductRepository.deleteByProduct(id);
    }
}
