package com.myorgn.bucarestbank;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.entity.Transaction;
import com.myorgn.bucarestbank.repository.AccountRepository;
import com.myorgn.bucarestbank.repository.TransactionRepository;

@SpringBootApplication
public class BucarestbankApplication {

  public static void main(String[] args) {
    SpringApplication.run(BucarestbankApplication.class, args);
  }

  @Bean
  public CommandLineRunner demoData(AccountRepository accountRepo, TransactionRepository transactionRepo) {
    return args -> {
      // Add some demo accounts and transactions...
      Account account = new Account("123456789", "John Doe", 0.05, 1000.0);
      Transaction initialTransaction = new Transaction(account, LocalDateTime.now(), false, 1000.0, "Initial balance");
      account.addTransaction(initialTransaction);

      accountRepo.save(account);
    };
  }
}