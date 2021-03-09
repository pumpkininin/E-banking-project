package Models;

public class Merchant {
	private int merchant_id;
	private String merchant_name;
	private String merchant_phone;
	private String merchant_email;
	private String other_details;
	
	public Merchant() {
		
	}

	public Merchant(int merchant_id, String merchant_name, String merchant_phone, String merchant_email,
			String other_details) {
		this.merchant_id = merchant_id;
		this.merchant_name = merchant_name;
		this.merchant_phone = merchant_phone;
		this.merchant_email = merchant_email;
		this.other_details = other_details;
	}
	
	public Merchant(String merchant_name, String merchant_phone, String merchant_email,
			String other_details) {
		this.merchant_name = merchant_name;
		this.merchant_phone = merchant_phone;
		this.merchant_email = merchant_email;
		this.other_details = other_details;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getMerchant_phone() {
		return merchant_phone;
	}

	public void setMerchant_phone(String merchant_phone) {
		this.merchant_phone = merchant_phone;
	}

	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}

	public String getOther_details() {
		return other_details;
	}

	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}
	
	
}
