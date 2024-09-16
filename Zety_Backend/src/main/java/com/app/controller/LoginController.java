package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class LoginController {

	@Autowired
	UserService service;
	
	  @PostMapping("/login")
	    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginDTO loginDTO) {
	        ApiResponse response = service.authenticateUser(loginDTO);
	        if(response.isSuccess()) {
	        	
	        	// After successful login, check the role
	            User user = service.findByEmail(loginDTO.getEmail());
	            if (user.getRole() == Role.ADMIN) {
	                response.setMessage("Admin login successful");
	                // You can return different response headers or tokens here if needed
	            } else if (user.getRole() == Role.USER) {
	                response.setMessage("User login successful");
	            }
	            
	        	return ResponseEntity.ok(response);
	        } else
	        return  ResponseEntity.badRequest().body(response);
	    }
	  
	  @PostMapping("/logout")
	    public ResponseEntity<ApiResponse> logout(@RequestParam String email) {
	        System.out.println("Received logout request for email: " + email);
	        ApiResponse response = new ApiResponse();

	        // Update logout time for the user with the provided email
	        service.updateLogoutTime(email);

	        response.setMessage("Logout successful");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
}
