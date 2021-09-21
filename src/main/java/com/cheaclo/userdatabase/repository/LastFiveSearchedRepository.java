package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.LastFiveSearched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LastFiveSearchedRepository extends JpaRepository<LastFiveSearched, Long> {
}

