package edu.jsp.Banking_App.controller;

import java.util.Set;

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
	
	public Loan applyLoan(Long userId,Loan loan)
	{
		
			return  loanService.applyLoan(userId, loan);
	}
	
	public Loan getLoan(long loanId)
	{
		return loanService.getLoanById(loanId);
	}
	
	public Loan updateLoan(long loanId,Loan loan)
	{
		return loanService.updateLoan(loanId, loan);
	}
	
	public String deleteById(long userId,long loanId)
	{
		return loanService.deleteLoanById(userId, loanId);
	}
	
	public Set<Loan> fetchAllLoan(long userId)
	{
		return loanService.fetchAllLoan(userId);
	}
	
	public Loan repayLoan(long loanId,double amount) {
		
		return loanService.repayLoan(loanId, amount);
		
	}
	
	public String loanStaus(long loanId)
	{
		return loanService.loanStatus(loanId);
	}
	
	
	
	
	
	
	

}
