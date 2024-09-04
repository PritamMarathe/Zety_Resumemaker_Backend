package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;
import com.app.dto.CombinedResponseDto;
import com.app.entity.BasicDetails;
import com.app.service.BasicDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("user")
public class BasicDetailsController {

    @Autowired
    private BasicDetailsService service;
    
    
   /* @PostMapping("addBasicdetail")
    public ResponseEntity<?> addUsersBasicDetails(@RequestBody BesicDetailsDto details) {
      
    	return ResponseEntity.status(HttpStatus.CREATED).body(service.addBasicDetails(details));
    }*/
    
    //multipart/form-data media type is required to send files along with other form data.
    @PostMapping(value="addBasicdetails" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse addBasicDetails(
            @RequestPart("details") String detailsJson,
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage) {//The MultipartFile class is used in Spring Boot to handle file uploads.

        BesicDetailsDto details;
        try {
            ObjectMapper objectMapper = new ObjectMapper();    //objectMapper is used to convert json string into besicdetails dto object 
            details = objectMapper.readValue(detailsJson, BesicDetailsDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ApiResponse("Failed to parse JSON data");
        }

        if (profileImage != null && !profileImage.isEmpty()) {
            try {
                byte[] imageBytes = profileImage.getBytes();  //if image is uploaded its byte are read and set into besicdetailsdto
                details.setProfileImage(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
                return new ApiResponse("Image upload failed");
            }
        }

        return service.addBasicDetails(details);
    }
    
   /* @GetMapping("getBasicdetails/{userId}")
    public ResponseEntity<?>getUserBasicDetails(@PathVariable Long userId){
    	
    	return ResponseEntity.ok(service.getBasicDetailsById(userId));
    }*/
    
    @GetMapping("/profile-image/{id}")
    public ResponseEntity<byte[]> getProfileImage(@PathVariable Long id) {
        byte[] imageData = service.getProfileImageById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.IMAGE_JPEG); // or IMAGE_PNG, depending on your image format
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
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


