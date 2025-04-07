package edu.jsp.Banking_App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_App.entity.Account;
import edu.jsp.Banking_App.entity.Transaction;
import edu.jsp.Banking_App.repo.AccountRepo;
import edu.jsp.Banking_App.repo.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	
	public Transaction addTransaction(Long accountId,Transaction transaction)
	{
		  
		Account account= accountRepo.findById(accountId).orElse(null);
		
		if(account!=null) {
			account.addTransaction(transaction);
			accountRepo.save(account);
			return transaction;
		}
		return null;
	}
	
}
