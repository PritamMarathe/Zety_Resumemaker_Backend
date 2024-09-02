package com.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
}
