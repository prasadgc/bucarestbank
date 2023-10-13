package com.myorgn.bucarestbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount( String accountNumber ) {
        return accountRepository.findById(accountNumber).isPresent() ? accountRepository.findById(accountNumber).get() : null;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }
}
