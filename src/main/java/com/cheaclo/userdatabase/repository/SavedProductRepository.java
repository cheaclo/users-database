package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.SavedProduct;
import com.cheaclo.userdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SavedProductRepository extends JpaRepository<SavedProduct, Long> {
    SavedProduct findFirstByUserAndProduct(User user, Long product);

    @Query(value = "select product from saved_product where user_id=:userId", nativeQuery = true)
    List<Long> findAllByUserId(Long userId);

    @Modifying
    void deleteByProduct(Long product);
}

