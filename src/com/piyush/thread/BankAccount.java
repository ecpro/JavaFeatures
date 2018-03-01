package com.piyush.thread;

public class BankAccount {
	
	private Double amount;
	
	public BankAccount(Double amount) {
		this.amount = amount;
	}
	
	public synchronized void deposit(Double amount) {
		System.out.print("Prev amount : " + this.amount);
		this.amount += amount;
		System.out.print(" Next amount : " + this.amount + "\n");
	}
	
	public Double getAmount() {
		return this.amount;
	}
	
	public double withdraw(Double amount) throws BusinessException {
		if(this.amount.compareTo(amount) < 0) {
			throw new BusinessException("Insufficient balance");
		}
		this.amount = this.amount - amount;
		return amount;
	}
}
