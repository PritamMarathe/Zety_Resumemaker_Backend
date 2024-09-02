package com.app.dto;

import java.util.List;

public class ResponseProjectDto {
	
	private int id;
	
	private String ProjectTitle;

	private String ProjectRole;

	private List<String> Techstack;

	private String ProjectLink;

	private String Description;

	public ResponseProjectDto(String projectTitle, String projectRole, List<String> techstack, String projectLink,
			String description) {
		super();
		ProjectTitle = projectTitle;
		ProjectRole = projectRole;
		Techstack = techstack;
		ProjectLink = projectLink;
		Description = description;
	}
	
	
	public ResponseProjectDto() {
		super();
	}


	public String getProjectTitle() {
		return ProjectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		ProjectTitle = projectTitle;
	}

	public String getProjectRole() {
		return ProjectRole;
	}

	public void setProjectRole(String projectRole) {
		ProjectRole = projectRole;
	}

	public List<String> getTechstack() {
		return Techstack;
	}

	public void setTechstack(List<String> techstack) {
		Techstack = techstack;
	}

	public String getProjectLink() {
		return ProjectLink;
	}

	public void setProjectLink(String projectLink) {
		ProjectLink = projectLink;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
}
