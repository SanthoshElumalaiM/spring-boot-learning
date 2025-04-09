package edu.jsp.Banking_App.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private Set<Loan> loans;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Account> accounts;
	
	public void addLoan(Loan loan)
	{
		loans.add(loan);
		loan.setUser(this);
	}
	
	public void removeLoan(Loan loan)
	{
		loans.remove(loan);
		loan.setUser(this);
	}
	
	public void addAccount(Account account)
	{
		accounts.add(account);
		account.setUser(this);;;
	}
	public void removeAccont(Account account)
	{
		accounts.remove(account);
		account.setUser(this);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	
}
