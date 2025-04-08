package edu.jsp.Banking_App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_App.entity.Account;
import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.repo.AccountRepo;
import edu.jsp.Banking_App.repo.UserRepo;

@Service
public class AccountService {

	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public Account createAccount(long userId,Account account)
	{
		
		User user= userRepo.findById(userId).orElse(null);
		
		if(user!=null)
		{
		  user.addAccount(account);
		  userRepo.save(user);
		  return account;
		}
		return null;
	}
	
	public Account updateAccount(long accountId,Account newAccount)
	{
		Account exAccount= accountRepo.findById(accountId).orElse(null);
		
		if(exAccount!=null)
		{
			newAccount.setId(accountId);
			return accountRepo.save(newAccount);
		}
		return null;
			
	}
	
	public String deleteAccountById(long userId,long accountId)
	{
		User user=  userRepo.findById(userId).orElse(null);
		Account account= accountRepo.findById(accountId).orElse(null);
		
		if(user!=null)
		{
			user.removeAccont(account);
			accountRepo.delete(account);
			return "Account deleted ";
		}
		return "Id Not found";
	}
	
	public List<Account> getAccountById(long userId)
	{
		return accountRepo.getAccountByUserId(userId);
	}
	
	public double accountBalance(long accountId)
	{
		Account account= accountRepo.findById(accountId).orElse(null);
		return account.getBalance();
	}
}
