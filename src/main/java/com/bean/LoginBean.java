package com.bean;

import javax.validation.constraints.NotBlank;

public class LoginBean {
	@NotBlank(message = "Please enter email")
	String email;
	
	@NotBlank(message = "Please enter password")
	String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}