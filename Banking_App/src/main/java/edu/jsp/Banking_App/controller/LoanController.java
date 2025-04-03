package edu.jsp.Banking_App.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_App.entity.Loan;
import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.service.LoanService;

@RestController
//@RequestMapping("/loans")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/users/{userId}")
	public Loan applyLoan(@PathVariable Long userId,@RequestBody Loan loan)
	{
		
			return  loanService.applyLoan(userId, loan);
	}
	
	@GetMapping("/loans/{loanId}")
	public Loan getLoan(@PathVariable long loanId)
	{
		return loanService.getLoanById(loanId);
	}
	
	@PutMapping("/loans/{loanId}")
	public Loan updateLoan(@PathVariable long loanId,@RequestBody Loan loan)
	{
		return loanService.updateLoan(loanId, loan);
	}
	
	@DeleteMapping("/users/{userId}/loans/{loanId}")
	public String deleteLoanById(@PathVariable long userId,@PathVariable long loanId)
	{
		return loanService.deleteLoanById(userId, loanId);
	}
	
	@GetMapping("/users/{userId}/loans")
	public Set<Loan> fetchAllLoan(@PathVariable long userId)
	{
		return loanService.fetchAllLoan(userId);
	}
	
	@PutMapping("loans/{loanId}/{amount}")
	public Loan repayLoan(@PathVariable long loanId,@PathVariable double amount) {
		
		return loanService.repayLoan(loanId, amount);
		
	}
	
	@GetMapping("/loans/status/{loanId}")
	public String loanStatus(@PathVariable long loanId)
	{
		return loanService.loanStatus(loanId);
	}
	
	
	
	
	
	
	

}
