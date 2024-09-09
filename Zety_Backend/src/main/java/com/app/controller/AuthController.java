package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	 @GetMapping("/auth/login/facebook")
	    public String facebookLogin() {
	        // Redirect to the Facebook login URL
	        return "redirect:/oauth2/authorization/facebook";
	    }
	 
	 @GetMapping("/data-deletion")
	    public ResponseEntity<String> getDataDeletionInstructions() {
	        String instructions = "To request data deletion, please email us at support@yourapp.com with your username or registered email.";
	        return new ResponseEntity<>(instructions, HttpStatus.OK);
	    }
	 
	 @GetMapping("/auth/login/google")
	 public String googleLogin() {
		 return "redirect:/oauth2/authorization/google";
	 }
}
