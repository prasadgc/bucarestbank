package com.myorgn.bucarestbank.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

  public Transaction() {
  }

  public Transaction(Account account, LocalDateTime transactionDate, boolean isDebit,
      Double transactionAmount, String transactionDescription) {
    this.account = account;
    this.transactionDate = transactionDate;
    this.isDebit = isDebit;
    this.transactionAmount = transactionAmount;
    this.transactionDescription = transactionDescription;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_number")
  private Account account;

  private LocalDateTime transactionDate;
  private boolean isDebit; // You might want to use Enum instead
  private Double transactionAmount;
  private String transactionDescription;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public LocalDateTime getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDateTime transactionDate) {
    this.transactionDate = transactionDate;
  }

  public boolean getIsDebit() {
    return isDebit;
  }

  public void setIsDebit(boolean isDebit) {
    this.isDebit = isDebit;
  }

  public Double getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(Double transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public String getTransactionDescription() {
    return transactionDescription;
  }

  public void setTransactionDescription(String transactionDescription) {
    this.transactionDescription = transactionDescription;
  }

  public String toString() {
    return "Transaction [id=" + id + ", account=" + account + ", transactionDate=" + transactionDate
        + ", isDebit=" + isDebit + ", transactionAmount=" + transactionAmount
        + ", transactionDescription=" + transactionDescription + "]";
  }
}
