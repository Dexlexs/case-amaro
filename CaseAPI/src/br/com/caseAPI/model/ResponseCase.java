package br.com.caseAPI.model;

import org.hibernate.validator.constraints.NotBlank;

public class ResponseCase {

	@NotBlank(message="{field.required}")
	public Long timestamp;
	
	@NotBlank(message="{field.required}")
	public Platform platform;
	
	@NotBlank(message="{field.required}")
	public String product;
	
	@NotBlank(message="{field.required}")
	public double ctr;
	
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform2) {
		this.platform = platform2;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getCtr() {
		return ctr;
	}

	public void setCtr(double ctr) {
		this.ctr = ctr;
	}
	
}
