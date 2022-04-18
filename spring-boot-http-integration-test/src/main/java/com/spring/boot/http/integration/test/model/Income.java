package com.spring.boot.http.integration.test.model;

public class Income extends AccountsTransaction {
	public Income(String description, Double amount) {
		this.description = description;
		this.amount = amount;
	}
}
