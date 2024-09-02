package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.dao.ProjectDao;
import com.app.dto.ApiResponse;
import com.app.dto.ProjectDto;
import com.app.dto.ResponseProjectDto;
import com.app.entity.BasicDetails;
import com.app.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private BesicDetailsDao besicDetailsDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addProject(ProjectDto dto) {
		
		Project project = mapper.map(dto, Project.class);
		
		BasicDetails basicDetails = besicDetailsDao.findById(dto.getUser_Id()).orElseThrow(()->new RersourseNotFoundException("User Cannot be found"));
		
		basicDetails.addProject(project);
		
		projectDao.save(project);
		
		return new ApiResponse("Project details Added Sucsessfully");
	}

	@Override
	public List<ResponseProjectDto> getProject(Long userId) {
		
		BasicDetails basicDetails = besicDetailsDao.findById(userId).orElseThrow(()->new RersourseNotFoundException("User Cannot be found"));

		return basicDetails.getProjects().stream()
				.map(p->mapper.map(p, ResponseProjectDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse updateProject(Long id, ProjectDto dto) {
		
		Project existingProject = projectDao.findById(id).orElseThrow(()-> new RersourseNotFoundException("Project Details Cannot be found"));
		
		mapper.map(dto, existingProject);
		
		projectDao.save(existingProject);
		
		return new ApiResponse("Project Details Updated Sucsessfully");
	}

	@Override
	public ApiResponse deleteProject(Long id) {
		
		Project project = projectDao.findById(id).orElseThrow(()-> new RersourseNotFoundException("Project Details Cannot be found"));
		
		BasicDetails basicDetails = besicDetailsDao.findById(project.getDetailsProject().getId()).orElseThrow(()->new RersourseNotFoundException("User Cannot be found"));

		basicDetails.removeProject(project);
		
		projectDao.delete(project);
		
		return new ApiResponse("Project Details has been deleted");
	}

}
