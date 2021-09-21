package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.SavedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedProductRepository extends JpaRepository<SavedProduct, Long> {
}

