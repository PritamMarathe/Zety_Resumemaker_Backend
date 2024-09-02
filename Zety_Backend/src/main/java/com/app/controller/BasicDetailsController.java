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

import com.app.dto.BesicDetailsDto;
import com.app.dto.CombinedResponseDto;
import com.app.service.BasicDetailsService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class BasicDetailsController {

    @Autowired
    private BasicDetailsService service;
    
    
    @PostMapping("addBasicdetails")
    public ResponseEntity<?> addUsersBasicDetails(@RequestBody BesicDetailsDto details) {
      
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.addBasicDetails(details));
    }
    
    @GetMapping("getBasicdetails/{userId}")
    public ResponseEntity<?>getUserBasicDetails(@PathVariable Long userId){
    	
    	return ResponseEntity.ok(service.getBasicDetailsById(userId));
    }
    

    @PutMapping("updateBasicdetails/{userId}")
    public ResponseEntity<?> updateUserBasicDetails(@PathVariable Long userId, @RequestBody BesicDetailsDto details) {
        return ResponseEntity.ok(service.updateBasicDetails(userId, details));
    }	
    
    @DeleteMapping("deleteBasicDetals/{userId}")
    public ResponseEntity<?> deleteUserBesicDetails(@PathVariable Long userId){
    	
    	return ResponseEntity.ok(service.deleteBesicdetails(userId));
    }

    //API For getting the combined service
    
    @GetMapping("getAllBasicDetails/{id}")
    public ResponseEntity<?>getAllData(@PathVariable Long id){
    	
    	CombinedResponseDto responseDto = service.getCombinedData(id);
    	
    	if(responseDto == null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return ResponseEntity.ok(responseDto);
    }
}
