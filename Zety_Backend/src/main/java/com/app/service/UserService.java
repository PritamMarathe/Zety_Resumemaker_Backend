package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.PasswordResetDto;
import com.app.dto.LoginDTO;
import com.app.dto.SignupDto;
import com.app.dto.UserDto;
import com.app.entity.User;


public interface UserService {
	ApiResponse userRegister(SignupDto signupDto);

	ApiResponse resetUserPassword(PasswordResetDto passwordResetDto);
	
	ApiResponse authenticateUser(LoginDTO loginDTO);

	
	
}
