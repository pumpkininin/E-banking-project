package com.se2.ebanking.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class Account {
	private long account_id;
	private Date open_date;
	private float balance;
	private String account_type;
	private long customer_id;




	public Account(long account_id, Date open_date, float balance, String account_type, long customer_id) {
		this.account_id = account_id;
		this.open_date = open_date;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
	}
	public Account(Date open_date, float balance, String account_type, long customer_id) {

		this.open_date = open_date;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
	}

}