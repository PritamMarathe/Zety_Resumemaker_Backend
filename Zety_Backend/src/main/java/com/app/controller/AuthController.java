package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	 @GetMapping("/auth/login/facebook")
	    public String facebookLogin() {
	        // Redirect to the Facebook login URL
	        return "redirect:/oauth2/authorization/facebook";
	    }
	 
	 @GetMapping("/auth/login/google")
	 public String googleLogin() {
		 return "redirect:/oauth2/authorization/google";
	 }
}
