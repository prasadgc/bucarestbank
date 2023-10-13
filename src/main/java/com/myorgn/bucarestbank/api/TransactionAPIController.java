package com.myorgn.bucarestbank.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.entity.Transaction;
import com.myorgn.bucarestbank.service.AccountService;
import com.myorgn.bucarestbank.service.TransactionService;

@RestController
@RequestMapping("/api/v1")
public class TransactionAPIController {

  AccountService accountService;
  TransactionService transactionService;

  @Autowired
  public TransactionAPIController(AccountService accountService,
      TransactionService transactionService) {
    this.accountService = accountService;
    this.transactionService = transactionService;
  }

  @PostMapping("/payments")
  public ResponseEntity<?> makePayment(
      @RequestParam("accountNumber") String accountNumber,
      @RequestParam("amount") Double amount,
      @RequestParam("description") String description) {
    // Process payment and update DB
    Account account = accountService.getAccount(accountNumber);

    // Check for valid amount
    if (amount <= 0 ) {
      return ResponseEntity.badRequest().body("Invalid amount");
    }

    // Check for sufficient funds
    if (account.getCurrentBalance() < amount) {
      return ResponseEntity.badRequest().body("Insufficient funds");
    }

    Transaction transaction = new Transaction(account, LocalDateTime.now(), true, amount, description);
    Double previousBalance = account.getCurrentBalance();
    account.setCurrentBalance(previousBalance - amount);
    account.addTransaction(transaction);
    accountService.saveAccount(account);

    HttpHeaders headers = new HttpHeaders();
    headers.add("HX-Trigger", "account.currentBalance");
    headers.add("HX-Trigger", "transactions");

    return new ResponseEntity<>(headers, HttpStatus.OK);
  }
}