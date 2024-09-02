package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.ExperianceDto;

public interface ExperianceService {
	ApiResponse addExperiance(ExperianceDto dto);
	List<ExperianceDto> getExperiance(Long userId);
	ApiResponse updateExperience(Long id,ExperianceDto dto);
	ApiResponse deleteExperiance(Long id);

}



