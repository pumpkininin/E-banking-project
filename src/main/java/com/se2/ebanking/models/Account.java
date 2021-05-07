package com.se2.ebanking.models;


import java.sql.Date;


public class Account {
	private long account_id;
	private Date open_date;
	private float balance;
	private String account_type;
	private long customer_id;
	private int is_active;




	public Account(long account_id, Date open_date, float balance, String account_type, long customer_id, int is_active) {
		this.account_id = account_id;
		this.open_date = open_date;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
		this.is_active = is_active;
	}
	public Account(Date open_date, float balance, String account_type, long customer_id, int is_active) {

		this.open_date = open_date;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
		this.is_active  = is_active;
	}

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
}
