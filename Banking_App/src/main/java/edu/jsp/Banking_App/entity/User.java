package edu.jsp.Banking_App.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long uid;
	private String name;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Loan> loans;
	
	public void addLoan(Loan loan)
	{
		loans.add(loan);
		loan.setUser(this);
	}
}
