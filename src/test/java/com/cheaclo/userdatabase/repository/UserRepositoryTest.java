package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private final String firstEmail = "first@gmail.com";
    private final String secondEmail = "second@gmail.com";
    private final Long firstId = 1L;
    private final Long secondId = 2L;

    @Test
    void findFirstByAccountInfo_Email() {
        User firstUser = userRepository.findFirstByAccountInfo_Email(firstEmail);
        assert(firstUser != null);

        User notExistingUser = userRepository.findFirstByAccountInfo_Email("some@gmail.com");
        assert(notExistingUser == null);

        User secondUser = userRepository.findFirstByAccountInfo_Email(secondEmail);
        assert(secondUser != null);
    }

    @Test
    void findFirstByIdAndAccountInfo_EmailIgnoreCase() {
        User firstUser = userRepository.findFirstByIdAndAccountInfo_EmailIgnoreCase(firstId, firstEmail.toUpperCase());
        assert(firstUser != null);

        User notExistingUser = userRepository.findFirstByIdAndAccountInfo_EmailIgnoreCase(secondId,"some@gmail.com");
        assert(notExistingUser == null);

        User secondUser = userRepository.findFirstByIdAndAccountInfo_EmailIgnoreCase(2L, secondEmail.toLowerCase());
        assert(secondUser != null);
    }
}