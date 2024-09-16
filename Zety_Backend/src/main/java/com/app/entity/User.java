package com.app.entity;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")

public class User extends BaseEntity {

	@Column(name = "email", length = 100)
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "provider")
	private String provider; // e.g., "GOOGLE"

	@Column(name = "provider_id")
	private String providerId; // google unique user ID
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private LocalTime logintime;
	private LocalTime logouttime;


	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private BasicDetails basicDetails;

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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public BasicDetails getBesicDetails() {
		return basicDetails;
	}

	public void setBesicDetails(BasicDetails basicDetails) {
		this.basicDetails = basicDetails;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalTime getLogintime() {
		return logintime;
	}

	public void setLogintime(LocalTime logintime) {
		this.logintime = logintime;
	}

	public LocalTime getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(LocalTime logouttime) {
		this.logouttime = logouttime;
	}
	
	
}
