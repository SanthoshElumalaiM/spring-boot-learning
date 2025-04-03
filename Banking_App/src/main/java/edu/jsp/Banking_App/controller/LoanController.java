package edu.jsp.Banking_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_App.entity.Loan;
import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.service.LoanService;

@RestController
//@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	public Loan applyLoan(User userId,Loan loan)
	{
		
			return  loanService.applyLoan(userId, loan);
	}
	
	
	
	
	
	
	
	

}
