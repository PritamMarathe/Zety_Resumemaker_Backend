package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.BesicDetailsDto;
import com.app.dto.CombinedResponseDto;
import com.app.entity.BasicDetails;

public interface BasicDetailsService {
	BesicDetailsDto getBasicDetailsById(Long id);

	ApiResponse addBasicDetails(BesicDetailsDto details);

	ApiResponse updateBasicDetails(Long id, BesicDetailsDto details);

	ApiResponse deleteBesicdetails(Long userId);
	
	CombinedResponseDto getCombinedData(Long id);
	
    byte[] getProfileImageById(Long id);
    
    public void saveImageToLocalFolder(MultipartFile imageFile) throws IOException;
    
    public ApiResponse updateProfileimage(Long userId,MultipartFile profileImage) throws IOException;
        
}
