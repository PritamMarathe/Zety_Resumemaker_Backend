package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;
import com.app.dto.UserDto;
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
	        	return ResponseEntity.ok(response);
	        } else
	        return  ResponseEntity.badRequest().body(response);
	    }
	
}
