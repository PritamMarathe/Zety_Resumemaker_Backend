package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.EducationDto;

public interface EducationSerivce {
	ApiResponse addEducation(EducationDto Dto);
	List<EducationDto> getEducation(Long userId);
	ApiResponse updateEducation(Long id,EducationDto dto);
	ApiResponse deleteEducation(Long id);

}
