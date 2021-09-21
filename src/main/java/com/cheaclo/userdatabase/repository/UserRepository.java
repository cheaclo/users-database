package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
