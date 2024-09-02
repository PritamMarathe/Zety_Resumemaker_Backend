package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ProjectDto;
import com.app.dto.ResponseProjectDto;

public interface ProjectService {

	ApiResponse addProject(ProjectDto dto);

	List<ResponseProjectDto> getProject(Long userId);

	ApiResponse updateProject(Long id, ProjectDto dto);

	ApiResponse deleteProject(Long id);
	
	

}
