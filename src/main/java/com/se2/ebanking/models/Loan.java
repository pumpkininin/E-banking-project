package com.se2.ebanking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
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


}
