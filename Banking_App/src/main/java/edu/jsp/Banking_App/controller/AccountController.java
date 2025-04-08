package edu.jsp.Banking_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_App.entity.Account;
import edu.jsp.Banking_App.service.AccountService;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("accounts/{userId}")
	public Account createAccount(@PathVariable long userId,@RequestBody Account account ) {
		
		return accountService.createAccount(userId, account);
	}
	
	@PostMapping("accounts/{accountId}")
	public Account updateAccount(@PathVariable long accountId,@RequestBody Account newAccount)
	{
		return accountService.updateAccount(accountId, newAccount);
	}
	
	@DeleteMapping("acccounts/{userId}/{accountId}")
	public String deleteAccount(@PathVariable long userID,@PathVariable   long accountId)
	{
		return accountService.deleteAccountById(userID, accountId);
	}
	
	@GetMapping("accounts/{userId}")
	public List<Account> getAccountById(@PathVariable long userId)
	{
		return accountService.getAccountById(userId);
	}
}
