package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.EducationDto;
import com.app.entity.Education;
import com.app.service.EducationSerivce;

@CrossOrigin
@RestController
@RequestMapping("user")
public class EducationController {

	@Autowired
	private EducationSerivce educationService;

	@PostMapping("addEducation")
	public ResponseEntity<?> addEducation(@RequestBody EducationDto Dto) {
		System.out.println("No-Education Controller");
		return ResponseEntity.status(HttpStatus.CREATED).body(educationService.addEducation(Dto));
	}

	@GetMapping("getEducation/{userId}")
	public ResponseEntity<?> viewAllEducation(@PathVariable Long userId) {
		return ResponseEntity.ok(educationService.getEducation(userId));
	}
	
	@PutMapping("updateEducation/{id}")
	public ResponseEntity<?> updateEducation(@PathVariable Long id, @RequestBody EducationDto dto) {
	    return ResponseEntity.ok(educationService.updateEducation(id, dto));
	}
	@DeleteMapping("deleteEducation/{educationId}")
	public ResponseEntity<?>deleteEducationdetails(@PathVariable Long educationId){
		
		return ResponseEntity.ok(educationService.deleteEducation(educationId));
	}
	
}