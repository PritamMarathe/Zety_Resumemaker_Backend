package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.SkillDto;

public interface SkillService {
	ApiResponse addSkills(SkillDto dto);
	List<SkillDto> getSkills(Long userId);
    ApiResponse updateSkills(Long skillId, SkillDto dto);
	ApiResponse deleteSkills(Long id);


}
