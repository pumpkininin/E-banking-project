package com.se2.ebanking.models;



import java.sql.Date;


public class Loan {
	private long loan_id;
	private float loan_amount;
	private String loan_type;
	private int duration;
	private float interest_rate;
	private long customer_id;
	private Date loan_date;




	public Loan(long loan_id, float loan_amount, String loan_type, int duration, float interest_rate, long customer_id) {
		this.loan_id = loan_id;
		this.loan_amount = loan_amount;
		this.loan_type = loan_type;
		this.duration = duration;
		this.interest_rate = interest_rate;
		this.customer_id = customer_id;
	}

	public Loan(float loan_amount, int duration, float interest_rate, long customer_id, Date loan_date) {
		this.loan_amount = loan_amount;
		this.duration = duration;
		this.interest_rate = interest_rate;
		this.customer_id = customer_id;
		this.loan_date = loan_date;
	}

	public long getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(long loan_id) {
		this.loan_id = loan_id;
	}

	public float getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(float loan_amount) {
		this.loan_amount = loan_amount;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}
}
