package Models;

import java.sql.Date;

public class Transaction {
	private int transaction_id;
	private Date transaction_date;
	private float transaction_amount;
	private String other_details;
	private String transaction_type;
	private int customer_id;
	private int receiver_id;
	
	public Transaction() {
		
	}

	public Transaction(int transaction_id, Date transaction_date, float transaction_amount, String other_details,
			String transaction_type, int customer_id, int receiver_id) {
		this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
		this.other_details = other_details;
		this.transaction_type = transaction_type;
		this.customer_id = customer_id;
		this.receiver_id = receiver_id;
	}
	
	public Transaction(Date transaction_date, float transaction_amount, String other_details,
			String transaction_type, int customer_id, int receiver_id) {
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
		this.other_details = other_details;
		this.transaction_type = transaction_type;
		this.customer_id = customer_id;
		this.receiver_id = receiver_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public float getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(float transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	
	
	
}
