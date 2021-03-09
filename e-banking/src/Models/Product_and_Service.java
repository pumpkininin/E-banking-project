package Models;

public class Product_and_Service {
	private int pas_id;
	private String pas_description;
	private int merchant_id;
	
	public Product_and_Service() {
		
	}

	public Product_and_Service(int pas_id, String pas_description, int merchant_id) {
		this.pas_id = pas_id;
		this.pas_description = pas_description;
		this.merchant_id = merchant_id;
	}
	
	public Product_and_Service(String pas_description, int merchant_id) {
		this.pas_description = pas_description;
		this.merchant_id = merchant_id;
	}

	public int getPas_id() {
		return pas_id;
	}

	public void setPas_id(int pas_id) {
		this.pas_id = pas_id;
	}

	public String getPas_description() {
		return pas_description;
	}

	public void setPas_description(String pas_description) {
		this.pas_description = pas_description;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	
	
}
