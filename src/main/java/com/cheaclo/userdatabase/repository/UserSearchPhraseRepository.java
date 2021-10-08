package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.UserSearchPhrase;
import com.cheaclo.userdatabase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSearchPhraseRepository extends JpaRepository<UserSearchPhrase, Long> {
    List<UserSearchPhrase> findAllByUserOrderBySearchDate(User user);
}

