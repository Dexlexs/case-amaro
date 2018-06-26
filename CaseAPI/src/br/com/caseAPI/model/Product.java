package br.com.caseAPI.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Product {

	@NotBlank(message="{field.required}")
	private int id;
	
	@NotBlank(message="{field.required}")
	private String sku;
	
	@NotBlank(message="{field.required}")
	private String code_color;
	
	@NotBlank(message="{field.required}")
	private Double prices;
	

	public int getId() {
		return id;
	}

	public Double getPrices() {
		return prices;
	}

	public void setPrices(Double prices) {
		this.prices = prices;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCode_color() {
		return code_color;
	}

	public void setCode_color(String code_color) {
		this.code_color = code_color;
	}
	
}
