package edu.jsp.Banking_App.service;

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
		 return account;
		}
		return null;
	}
	
}
