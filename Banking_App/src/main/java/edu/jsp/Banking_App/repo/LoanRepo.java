package edu.jsp.Banking_App.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Banking_App.entity.Loan;

public interface LoanRepo  extends JpaRepository<Loan, Long>{

}
