package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long> {
}

