package com.hcl.ecommerce.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

	@Size(min = 2, max = 6, message = "password should be minimum 2 characters and maximum 6 characters")
	@NotNull(message = "userName should be mandatory")
	private String userName;

	@Pattern(regexp = "[+] {1}[9] {1}[1] {1}[0-9] {10}")
	@NotNull(message = "phoneNumber should be mandatory")
	private Long phoneNumber;

	@NotNull(message = "phoneNumber should be mandatory")
	@Email(message = "Email should be valid")
	private String mail;
	
	@NotNull(message = "password should be mandatory")
	private String password;
	
	@NotNull(message = "userType should be mandatory")
	private String userType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
