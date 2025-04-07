package edu.jsp.Banking_App.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	private long accountNumber;
	private double balance;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private User user;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
	@JsonBackReference
	private List<Transaction> transactions;

	
	public void addTransaction(Transaction transaction)
	{
		transactions.add(transaction);
		transaction.setAccount(this);
	}
	
	public void deleteTransaction(Transaction transaction)
	{
		transactions.remove(transaction);
		transaction.setAccount(null);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}