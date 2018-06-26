package br.com.caseAPI.model;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

@Entity
public class Order {

	@NotBlank(message="{field.required}")
	private int id;
	
	@NotBlank(message="{field.required}")
	private Platform device;
	
	@NotBlank(message="{field.required}")
	private Date date;
	
	@NotBlank(message="{field.required}")
	private String utm_source_medium;
	
	@NotBlank(message="{field.required}")
	private String code_color;
	
	@NotBlank(message="{field.required}")
	private Long item_quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Platform getDevice() {
		return device;
	}

	public void setDevice(Platform device) {
		this.device = device;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUtm_source_medium() {
		return utm_source_medium;
	}

	public void setUtm_source_medium(String utm_source_medium) {
		this.utm_source_medium = utm_source_medium;
	}

	public String getCode_color() {
		return code_color;
	}

	public void setCode_color(String code_color) {
		this.code_color = code_color;
	}

	public Long getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(Long item_quantity) {
		this.item_quantity = item_quantity;
	}
	
}

