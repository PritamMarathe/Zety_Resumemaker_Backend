package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PasswordResetDto;
import com.app.dto.SignupDto;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService service;
	
	
	
	@PostMapping("/signUp")
	public ResponseEntity<ApiResponse>registerUser(@RequestBody SignupDto signupDto){
		 // Automatically assign role based on email domain
	    if (signupDto.getEmail().endsWith("@zohomail.in")) {
	        signupDto.setRole("ADMIN");  // Assign admin role for @numetry.com emails
	    } else {
	        signupDto.setRole("USER");   // Assign user role for other emails
	    }

	    // Call the service to register the user
	    ApiResponse response = service.userRegister(signupDto);

	    // Return appropriate response
	    if (response.isSuccess()) {
	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.badRequest().body(response);
	    }
	}
	
	@PostMapping("/resetPassword")
	public ResponseEntity<?>resetPassword(@RequestBody PasswordResetDto passwordResetDto){
		
		
		
		return ResponseEntity.ok(service.resetUserPassword(passwordResetDto));
	}
	
	
}
