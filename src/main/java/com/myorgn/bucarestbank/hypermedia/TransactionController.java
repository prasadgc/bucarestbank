package com.myorgn.bucarestbank.hypermedia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.entity.Transaction;
import com.myorgn.bucarestbank.service.AccountService;
import com.myorgn.bucarestbank.service.TransactionService;

@Controller
public class TransactionController {

  AccountService accountService;
  TransactionService transactionService;

  @Autowired
  public TransactionController(AccountService accountService,
      TransactionService transactionService) {
    this.accountService = accountService;
    this.transactionService = transactionService;
  }

  @GetMapping("/transactions")
  public String getTransactions(@RequestParam("accountNumber") String accountNumber, Model model) {
    Account account = accountService.getAccount(accountNumber);
    List<Transaction> transactions = transactionService.getSortedTransactionsForAccount(account);

    model.addAttribute("transactions", transactions);
    return "index :: #transactionsContent";
  }
}