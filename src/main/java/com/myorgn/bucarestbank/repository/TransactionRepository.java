package com.myorgn.bucarestbank.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findByAccount(Account account, Sort sort);
}
