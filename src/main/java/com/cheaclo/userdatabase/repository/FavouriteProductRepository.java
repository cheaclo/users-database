package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.FavouriteProduct;
import com.cheaclo.userdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavouriteProductRepository extends JpaRepository<FavouriteProduct, Long> {
    FavouriteProduct findFirstByUserAndProduct(User user, Long product);

    @Query(value = "select product from favourite_product where user_id=:userId", nativeQuery = true)
    List<Long> findAllByUserId(Long userId);

    @Modifying
    void deleteByProductAndUserId(Long product, Long userId);

    FavouriteProduct findFirstByProductAndUserId(Long product, Long userId);
}

