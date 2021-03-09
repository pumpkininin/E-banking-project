package Models;

import java.sql.Date;

public class Loan {
	private int loan_id;
	private float loan_amount;
	private String loan_type;
	private Date duration;
	private float interest_rate;
	private int customer_id;
	
	public Loan() {
		
	}

	public Loan(int loan_id, float loan_amount, String loan_type, Date duration, float interest_rate, int customer_id) {
		this.loan_id = loan_id;
		this.loan_amount = loan_amount;
		this.loan_type = loan_type;
		this.duration = duration;
		this.interest_rate = interest_rate;
		this.customer_id = customer_id;
	}
	
	public Loan(float loan_amount, String loan_type, Date duration, float interest_rate, int customer_id) {
		this.loan_amount = loan_amount;
		this.loan_type = loan_type;
		this.duration = duration;
		this.interest_rate = interest_rate;
		this.customer_id = customer_id;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
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

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public float getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(float interest_rate) {
		this.interest_rate = interest_rate;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
