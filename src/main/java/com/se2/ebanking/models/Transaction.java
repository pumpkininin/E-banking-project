package com.se2.ebanking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class Transaction {
	private long transaction_id;
	private Date transaction_date;
	private float transaction_amount;
	private String other_details;
	private String transaction_type;
	private long customer_id;
	private long receiver_id;
	private float transaction_fee;


	public Transaction(int transaction_id, Date transaction_date, float transaction_amount, String other_details, String transaction_type, int customer_id, int receiver_id, float transaction_fee) {
		this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
		this.other_details = other_details;
		this.transaction_type = transaction_type;
		this.customer_id = customer_id;
		this.receiver_id = receiver_id;
		this.transaction_fee = transaction_fee;
	}
	public Transaction(Date transaction_date, float transaction_amount, long customer_id, long receiver_id,String transaction_type, float transaction_fee) {
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
		this.customer_id = customer_id;
		this.receiver_id = receiver_id;
		this.transaction_fee = transaction_fee;
		this.transaction_type = transaction_type;
	}

    public Transaction(long id, Date transaction_date, float transaction_amount, long customer_id, long receiver_id, float transaction_fee) {
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
		this.customer_id = customer_id;
		this.receiver_id = receiver_id;
		this.transaction_fee = transaction_fee;
		this.transaction_id = id;
    }
}
