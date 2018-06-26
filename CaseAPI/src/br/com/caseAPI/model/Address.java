package br.com.caseAPI.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Address {
	
	@NotBlank(message="{field.required}")
	private int address_id;
	
	@NotBlank(message="{field.required}")
	private String adress_line;
	
	@NotBlank(message="{field.required}")
	private String adress_zipcode;
	
	@NotBlank(message="{field.required}")
	private String address_stat;
	
	@NotBlank(message="{field.required}")
	private String adress_country;

	protected int getAddress_id() {
		return address_id;
	}

	protected void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	protected String getAdress_line() {
		return adress_line;
	}

	protected void setAdress_line(String adress_line) {
		this.adress_line = adress_line;
	}

	protected String getAdress_zipcode() {
		return adress_zipcode;
	}

	protected void setAdress_zipcode(String adress_zipcode) {
		this.adress_zipcode = adress_zipcode;
	}

	protected String getAddress_stat() {
		return address_stat;
	}

	protected void setAddress_stat(String address_stat) {
		this.address_stat = address_stat;
	}

	protected String getAdress_country() {
		return adress_country;
	}

	protected void setAdress_country(String adress_country) {
		this.adress_country = adress_country;
	}
}
