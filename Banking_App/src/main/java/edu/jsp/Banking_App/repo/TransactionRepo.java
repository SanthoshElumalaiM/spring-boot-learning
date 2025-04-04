package edu.jsp.Banking_App.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Banking_App.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
