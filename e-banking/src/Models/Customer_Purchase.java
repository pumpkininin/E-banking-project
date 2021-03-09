package Models;

import java.sql.Date;

public class Customer_Purchase {
	private int purchase_id;
	private Date purchase_date;
	private float purchase_quantity;
	private String other_details;
	private int customer_id;
	private int pas_id;
	
	public Customer_Purchase() {
		
	}

	public Customer_Purchase(int purchase_id, Date purchase_date, float purchase_quantity, String other_details,
			int customer_id, int pas_id) {
		this.purchase_id = purchase_id;
		this.purchase_date = purchase_date;
		this.purchase_quantity = purchase_quantity;
		this.other_details = other_details;
		this.customer_id = customer_id;
		this.pas_id = pas_id;
	}
	
	public Customer_Purchase(Date purchase_date, float purchase_quantity, String other_details,
			int customer_id, int pas_id) {
		this.purchase_date = purchase_date;
		this.purchase_quantity = purchase_quantity;
		this.other_details = other_details;
		this.customer_id = customer_id;
		this.pas_id = pas_id;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public float getPurchase_quantity() {
		return purchase_quantity;
	}

	public void setPurchase_quantity(float purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getPas_id() {
		return pas_id;
	}

	public void setPas_id(int pas_id) {
		this.pas_id = pas_id;
	}
	
	
}
