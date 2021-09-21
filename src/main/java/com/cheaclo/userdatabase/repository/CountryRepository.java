package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}

