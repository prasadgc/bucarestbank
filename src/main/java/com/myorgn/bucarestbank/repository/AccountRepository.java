package com.myorgn.bucarestbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myorgn.bucarestbank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
