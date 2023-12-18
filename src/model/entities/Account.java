package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
			
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String withdraw(Double amount) throws DomainExceptions{
		if(amount > withdrawLimit) {
			throw new DomainExceptions("The amount exceeds withdraw limit");
		}
		if(balance < amount) {
			throw new DomainExceptions("Not enough balance");
		}
		if(amount instanceof Double != balance instanceof Double) {
			throw new DomainExceptions("Invalid data");
		}
		balance -= amount;
		System.out.printf("New balance: %.2f%n",balance);
		return null;
	}
}
