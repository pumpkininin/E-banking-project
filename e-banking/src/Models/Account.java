package Models;

import java.sql.Date;

public class Account {
	private int account_id;
	private Date open_date;
	private float balance;
	private String account_type;
	private int customer_id;
	
	public Account() {
		
	}

	public Account(int account_id, Date open_date, float balance, String account_type, int customer_id) {
		this.account_id = account_id;
		this.open_date = open_date;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
	}
	
	public Account(Date open_date, float balance, String account_type, int customer_id) {
		this.open_date = open_date;
		this.balance = balance;
		this.account_type = account_type;
		this.customer_id = customer_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
