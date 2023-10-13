package com.myorgn.bucarestbank.hypermedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myorgn.bucarestbank.entity.Account;
import com.myorgn.bucarestbank.service.AccountService;

@Controller
public class AccountController {

  // Inject services as needed
  AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/accountDetails")
  public String accountDetails(@RequestParam("accountNumber") String accountNumber, Model model) {
    // Fetch and add account details to model
    Account account = accountService.getAccount( accountNumber );
    model.addAttribute( "account", account );

    return "index :: #accountDetails";
  }

  @GetMapping("/accountBalance")
  public String accountBalance(@RequestParam("accountNumber") String accountNumber, Model model) {
    // Fetch and add account balance to model
    Account account = accountService.getAccount( accountNumber );
    model.addAttribute( "account", account );

    return "index :: #balanceContent";
  }
}
