package com.org.mfs.loans.model;

import java.util.Date;

public class LoanResponse {

	private Date requestDate;

	private int amount;
	
	

	public LoanResponse(Date requestDate, int amount) {
		super();
		this.requestDate = requestDate;
		this.amount = amount;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
