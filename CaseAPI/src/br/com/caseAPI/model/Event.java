package br.com.caseAPI.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Event {

	@NotBlank(message="{field.required}")
	public String type;

	@NotBlank(message="{field.required}")
	public String name;

	@NotBlank(message="{field.required}")
	public String codeColor;

	@NotBlank(message="{field.required}")
	public String timestamp;

	@NotBlank(message="{field.required}")
	public Long quantity;

	public Event(String type, String name, String codeColor, String timestamp) {
		this.type = type;
		this.name = name;
		this.codeColor = codeColor;
		this.timestamp = timestamp;
		this.quantity = 1L;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeColor() {
		return codeColor;
	}

	public void setCodeColor(String codeColor) {
		this.codeColor = codeColor;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
