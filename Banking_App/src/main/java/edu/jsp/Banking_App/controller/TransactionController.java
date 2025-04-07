package edu.jsp.Banking_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_App.entity.Transaction;
import edu.jsp.Banking_App.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("transaction/account/{accountId}")
	public Transaction addTransaction(@PathVariable long accountId,@RequestBody Transaction transaction)
	{
		return transactionService.addTransaction(accountId, transaction);
	}
	
	@GetMapping("transaction/getTransactionAsc/{userId}")
	public List<Transaction> getTransactionAsc(@PathVariable long userId)
	{
		return transactionService.getTransactionAsc(userId);
	}

}
