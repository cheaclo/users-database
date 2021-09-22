package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByAccountInfo_Email(String email);

    User findFirstByIdAndAccountInfo_EmailIgnoreCase(Long id, String email);
}

