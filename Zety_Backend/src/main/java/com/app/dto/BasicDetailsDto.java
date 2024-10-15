package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicDetailsDto {

		private long userId;
	    private String first_name;
	    private String last_name;  
	    private String email;
	    private String phone;
	    private String profession;
	    private String city;
	    private String country;
	    private String linkedin;
	    private String github;
	    private String message;
	    private byte [] profileImage;
	    
	   
		public BasicDetailsDto() {}

	public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

	public void setEmail(String email) {
			this.email = email;
		}

	public void setPhone(String phone) {
			this.phone = phone;
		}

	public void setProfession(String profession) {
			this.profession = profession;
		}

	public void setCity(String city) {
			this.city = city;
		}

	public void setCountry(String country) {
			this.country = country;
		}

	public void setLinkedin(String linkedin) {
			this.linkedin = linkedin;
		}

	public void setGithub(String github) {
			this.github = github;
		}

	public void setMessage(String message) {
			this.message = message;
		}

	public void setProfileImage(byte[] profileImage) {
			this.profileImage = profileImage;
		}

	

}