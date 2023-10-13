package com.myorgn.bucarestbank.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

  public Account() {
  }

  public Account(String accountNumber, String accountName, Double currentInterestRate, Double currentBalance) {
    this.accountNumber = accountNumber;
    this.accountName = accountName;
    this.currentInterestRate = currentInterestRate;
    this.currentBalance = currentBalance;
  }

  @Id
  String accountNumber;
  String accountName;
  Double currentInterestRate;
  Double currentBalance;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Transaction> transactions = new ArrayList<>();

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public Double getCurrentInterestRate() {
    return currentInterestRate;
  }

  public void setCurrentInterestRate(Double currentInterestRate) {
    this.currentInterestRate = currentInterestRate;
  }

  public Double getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(Double currentBalance) {
    this.currentBalance = currentBalance;
  }

  public void addTransaction( Transaction transaction ) {
    transactions.add(transaction);
    transaction.setAccount(this);
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public String toString() {
    return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", currentInterestRate="
        + currentInterestRate + ", currentBalance=" + currentBalance + "]";
  }
}
