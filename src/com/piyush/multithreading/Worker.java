package com.piyush.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {
	
	private BankAccount account;
	
	public Worker(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			account.deposit((double) (10));
		}
	}
	
	public static void main(String[] args) {
		BankAccount ba = new BankAccount((double) 100);
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 5; i++) {
			es.submit(new Worker(ba));
		}
		
		es.shutdown();
		
		try {
			es.awaitTermination(60, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(ba.getAmount());
	}
	
}
