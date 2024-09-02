package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProjectDto;
import com.app.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("user")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("addProject")
	public ResponseEntity<?> addProjectDetails(@RequestBody ProjectDto dto) {

		return ResponseEntity.ok(projectService.addProject(dto));
	}

	@GetMapping("getProject/{userId}")
	public ResponseEntity<?> getProjectDetails(@PathVariable Long userId) {
		
		return ResponseEntity.ok(projectService.getProject(userId));
	}
	
	@PutMapping("updateProject/{id}")
	public ResponseEntity<?> updateProjectDetails(@PathVariable Long id, @RequestBody ProjectDto dto){
		
		return ResponseEntity.ok(projectService.updateProject(id,dto));
	}
	
	@DeleteMapping("deleteProject/{id}")
	public ResponseEntity<?>deleteProjectDetails(@PathVariable Long id){
		
		return ResponseEntity.ok(projectService.deleteProject(id));
	}
}
