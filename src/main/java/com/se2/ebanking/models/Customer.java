package com.se2.ebanking.models;




import java.io.Serializable;
import java.sql.Date;


public class Customer implements Serializable {

	private long customer_id;
	private String customer_firstName;
	private String customer_lastName;
	private String customer_phone;
	private String customer_email;
	private Date customer_dob;
	private String customer_address;
	private Date join_date;
	private String login;
	private String password;
	private String other_details;
	private String customer_type;
	public Customer(){}

	public Customer(long customer_id, String customer_firstName,String customer_lastName, String customer_phone,
					String customer_email, Date customer_dob, String customer_address,
					Date join_date, String login, String password, String other_details, String customer_type) {
		this.customer_id = customer_id;
		this.customer_firstName = customer_firstName;
		this.customer_lastName = customer_lastName;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.customer_dob = customer_dob;
		this.customer_address = customer_address;
		this.join_date = join_date;
		this.login = login;
		this.password = password;
		this.other_details = other_details;
		this.customer_type = customer_type;
	}

	public Customer(long id, String firstName, String lastName, String phoneNumber, String address, String email, Date dob) {
		this.customer_id = id;
		this.customer_firstName = firstName;
		this.customer_lastName = lastName;
		this.customer_phone = phoneNumber;
		this.customer_email = email;
		this.customer_dob = dob;
		this.customer_address = address;
	}

	public Customer(String firstName, String lastName, String email, String phoneNumber, String address, Date dob) {
		this.customer_firstName = firstName;
		this.customer_lastName = lastName;
		this.customer_phone = phoneNumber;
		this.customer_email = email;
		this.customer_dob = dob;
		this.customer_address = address;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_firstName() {
		return customer_firstName;
	}

	public void setCustomer_firstName(String customer_name) {
		this.customer_firstName = customer_name;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public Date getCustomer_dob() {
		return customer_dob;
	}

	public void setCustomer_dob(Date customer_dob) {
		this.customer_dob = customer_dob;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}

	public String getCustomer_type() {
		return customer_type;
	}

	public String getCustomer_lastName() {
		return customer_lastName;
	}

	public void setCustomer_lastName(String customer_lastName) {
		this.customer_lastName = customer_lastName;
	}
	public String getName(){
		return customer_lastName + " " + customer_firstName;
	}

	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}
}
