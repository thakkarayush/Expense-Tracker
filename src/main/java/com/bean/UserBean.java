package com.bean;

import javax.validation.constraints.NotBlank;

public class UserBean {
	private Integer userId;
	@NotBlank(message = "Please enter firstname")
	private String firstName;
	@NotBlank(message = "Please enter lastname")
	private String lastName;
	@NotBlank(message = "Please enter email")
	private String email;
	@NotBlank(message = "Please enter password")
	private String password;
	@NotBlank(message = "Please enter gender")
	private String gender;
	private String userType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}