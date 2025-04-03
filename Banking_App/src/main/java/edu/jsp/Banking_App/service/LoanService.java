package edu.jsp.Banking_App.service;

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

}
