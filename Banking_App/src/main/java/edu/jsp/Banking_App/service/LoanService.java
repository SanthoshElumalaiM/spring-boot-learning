package edu.jsp.Banking_App.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_App.entity.Loan;
import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.repo.LoanRepo;
import edu.jsp.Banking_App.repo.UserRepo;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepo loanRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public  Loan applyLoan(Long userId,Loan loan) {
		
		 User u =userRepo.findById(userId).orElse(null);
		 
		 if(u!=null)
		 {
			 u.addLoan(loan);
			 
			 userRepo.save(u);
			 return loan;
		 }
		 return null;
	}
	
	public Loan getLoanById(long loanId)
	{
		return loanRepo.findById(loanId).orElse(null);
	}
	
	public Loan updateLoan(long loanId,Loan loan)
	{
		Loan exLoan= getLoanById(loanId);
		if(exLoan!=null)
		{
			loan.setId(loanId);
			 return loanRepo.save(loan);
		}
		return null;
	}

	public String deleteLoanById(long userId,long loanId)
	{
		 User user= userRepo.findById(userId).orElse(null);
		 
		 if(user!=null)
		 {
			 Loan loan=getLoanById(loanId);
			 user.removeLoan(loan);
			 loanRepo.delete(loan);
			 return "data deleted";
		 }
		 return "data not found";
		 
	}
	
	public  Set<Loan> fetchAllLoan(long userId){
		 User user= userRepo.findById(userId).orElse(null);
		 return user.getLoans();
	}
	
	public Loan repayLoan(long loanId,double amount)
	
	{
		 Loan loan= getLoanById(loanId);
		 if(loan!=null)
		 {
			 double bal=loan.getBalance();
			 loan.setBalance(bal-amount);
			 
			 return loanRepo.save(loan);
		 }
		 return null;
	}
	
	public String loanStatus(long loanId)
	{
		Loan loan= getLoanById(loanId);
		if(loan!=null)
		{
			 return loan.getStatus();
		}
		return null;
	}
}

