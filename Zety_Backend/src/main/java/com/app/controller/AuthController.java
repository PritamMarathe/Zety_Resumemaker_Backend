package com.app.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
	
	 //google login redirect url
	 @GetMapping("/auth/login/google")
	  public void googleLogin(HttpServletResponse response) throws IOException {
		 response.sendRedirect("/oauth2/authorization/google");
		 }
	 
	 //github redirect url
	 @GetMapping("/auth/login/github")
	  public void githubLogin(HttpServletResponse response) throws IOException {
	        response.sendRedirect("/oauth2/authorization/github");
	    }
	 
	 //fetching user info after success login
	 @GetMapping("/user/me")
	    public Map<String, Object> getCurrentUser(@AuthenticationPrincipal OAuth2User oAuth2User) {
		    // @AuthenticationPrincipal OAuth2User: This annotation allows you to access the logged-in OAuth2 user's details.
	        // Return the user attributes (email, name, etc.)
	        return oAuth2User.getAttributes();
	    }
}
