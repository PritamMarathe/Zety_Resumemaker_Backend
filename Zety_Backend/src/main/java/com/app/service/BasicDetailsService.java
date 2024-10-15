package com.app.service;

import java.io.IOException;

import com.app.dto.BasicDetailsDto;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.CombinedResponseDto;

public interface BasicDetailsService {
	BasicDetailsDto getBasicDetailsById(Long id);

	ApiResponse addBasicDetails(BasicDetailsDto details);

	ApiResponse updateBasicDetails(Long id, BasicDetailsDto details);

	ApiResponse deleteBesicdetails(Long userId);
	
	CombinedResponseDto getCombinedData(Long id);
	
    byte[] getProfileImageById(Long id);
    
    public void saveImageToLocalFolder(MultipartFile imageFile) throws IOException;
    
    public ApiResponse updateProfileimage(Long userId,MultipartFile profileImage) throws IOException;
        
}
