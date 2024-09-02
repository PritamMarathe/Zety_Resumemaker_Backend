package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

	private LocalDateTime timeStamp;
	
	private String message;
	
	private boolean success;
	

	public ApiResponse() {}
	
	public ApiResponse( String message) {
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
	
	
	public ApiResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
	
	public boolean isSuccess() {
		return success;
	}

	// Setter for the success field
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
