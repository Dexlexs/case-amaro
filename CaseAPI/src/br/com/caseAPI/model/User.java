package br.com.caseAPI.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User {
	
	@NotBlank(message="{field.required}")
	public static int user_id;
	
	@NotBlank(message="{field.required}")
	public String user_name;
	
	@NotBlank(message="{field.required}")
	public Address user_adress;

	public static int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		User.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Address getUser_adress() {
		return user_adress;
	}

	public void setUser_adress(Address user_adress) {
		this.user_adress = user_adress;
	}


}
