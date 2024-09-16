package com.app.dto;

import com.app.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SignupDto {
	
	private String email;
	private String password;
	private String confirmpassword;
	@JsonIgnore
	private String role;
	
	public SignupDto() {}
	
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
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
