package com.myorgn.bucarestbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.entity.Transaction;
import com.myorgn.bucarestbank.repository.AccountRepository;
import com.myorgn.bucarestbank.repository.TransactionRepository;


@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getSortedTransactionsForAccount( Account account ) {
        return transactionRepository.findByAccount(account, Sort.by(Sort.Order.desc("transactionDate")));
    }
}
