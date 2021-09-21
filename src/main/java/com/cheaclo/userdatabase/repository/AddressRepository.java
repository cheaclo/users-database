package com.cheaclo.userdatabase.repository;

import com.cheaclo.userdatabase.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

