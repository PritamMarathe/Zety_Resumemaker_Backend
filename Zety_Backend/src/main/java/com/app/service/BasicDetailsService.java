package com.app.service;

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
}
