package com.app.service;

import java.time.LocalTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.ApiResponse;
import com.app.dto.PasswordResetDto;
import com.app.dto.LoginDTO;
import com.app.dto.SignupDto;
import com.app.entity.Role;
import com.app.entity.User;

@Service
@Transactional
public class UserServiceImple implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public ApiResponse userRegister(SignupDto signupDto) {
	    if (!signupDto.getPassword().equals(signupDto.getConfirmpassword())) {
	        return new ApiResponse(false, "Passwords don't match!");
	    }

	    if (userDao.existsByEmail(signupDto.getEmail())) {
	        return new ApiResponse(false, "Email already exists");
	    }

	    User user = new User();
	    user.setEmail(signupDto.getEmail());
	    user.setPassword(passwordEncoder.encode(signupDto.getPassword()));

	    // Use the role from SignupDto
	    user.setRole(Role.valueOf(signupDto.getRole()));

	    userDao.save(user);
	    return new ApiResponse(true, "User registered successfully");
	}

	@Override
	public ApiResponse resetUserPassword(PasswordResetDto passwordResetDto) {
		
		User user = userDao.findByEmail(passwordResetDto.getEmail()).
				orElseThrow(()->new RersourseNotFoundException("User cannot be found with this email"));
		
		if(!passwordResetDto.getNewPassword().equals(passwordResetDto.getConfirmNewPassword())) {
			
			return new ApiResponse(false,"Password dosent match!");
		}
		
		user.setPassword(passwordEncoder.encode(passwordResetDto.getNewPassword()));
		
		return new ApiResponse(true,"password reset sucsessfulyy");
	}
		
	public ApiResponse authenticateUser(LoginDTO loginDTO) {
	    Optional<User> userOptional = userDao.findByEmail(loginDTO.getEmail());

	    if (userOptional.isEmpty()) {
	        return new ApiResponse(false, "User not found with this email");
	    }

	    User user = userOptional.get();
	    if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
	        return new ApiResponse(false, "Invalid password");
	    }

	    user.setLogintime(LocalTime.now());
	    userDao.save(user);

	    String role = user.getRole().name();
	    return new ApiResponse(true, "User login successful, Role: " + role);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public User findByEmail(String email) {
	    return userDao.findByEmail(email).orElseThrow(()->new RersourseNotFoundException("user not found"));
	}
	
	@Override
	public void updateLogoutTime(String email) {
		 try {
	            User user = findByEmail(email);
	            if (user != null) {
	                user.setLogouttime(LocalTime.now());
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Long findUserIdByEmail(String email) {
		return userDao.findByEmail(email)
				.map(User::getId)
				.orElseThrow(()->new RersourseNotFoundException("user not found with email:"+email));
	}
}
