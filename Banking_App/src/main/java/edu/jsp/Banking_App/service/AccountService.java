package edu.jsp.Banking_App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_App.repo.AccountRepo;

@Service
public class AccountService {

	
	@Autowired
	private AccountRepo accountRepo;
	
	
	
	
}
