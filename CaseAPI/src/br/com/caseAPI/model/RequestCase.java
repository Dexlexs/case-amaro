package br.com.caseAPI.model;

import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class RequestCase {

	@NotBlank(message="{field.required}")
	public Date startTimestamp;
	
	@NotBlank(message="{field.required}")
	public Date endTimestamp;
	
	@NotBlank(message="{field.required}")
	public int aggregation;
	
	public String product;
	
	public String platform;

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public int getAggregation() {
		return aggregation;
	}

	public void setAggregation(int aggregation) {
		this.aggregation = aggregation;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}

