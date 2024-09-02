package com.app.controller;

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

import com.app.dto.ExperianceDto;
import com.app.service.ExperianceService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class ExperianceController {
	
	@Autowired
	private ExperianceService service ;
	
	
	
	@PostMapping("addExperiance")
	public ResponseEntity<?> addExperianceDetails(@RequestBody ExperianceDto dto){
		
		System.out.println("inexperiance controller");
		return  ResponseEntity.status(HttpStatus.CREATED).body(service.addExperiance(dto));
	}
	
	@GetMapping("getExperiance/{userId}")
	public ResponseEntity<?> getExperianceDetails(@PathVariable Long userId){
		
		return ResponseEntity.ok(service.getExperiance(userId)); 
	}
	
	@PutMapping("updateExperiance/{id}")
	public ResponseEntity<?> updateExperianceDetails(@PathVariable Long id, @RequestBody ExperianceDto dto) {
	    return ResponseEntity.ok(service.updateExperience(id, dto));
	}
	
	
	@DeleteMapping("deleteExperiance/{experianceId}")
	public ResponseEntity<?>deleteExperianceDetails(@PathVariable Long experianceId){
		return ResponseEntity.ok(service.deleteExperiance(experianceId));
	}

}
