package com.app.dto;

import java.util.List;


public class ProjectDto {

	private Long User_Id;
	private String ProjectTitle;

	private String ProjectRole;

	private List<String> Techstack;

	private String ProjectLink;

	private String Description;

	public ProjectDto(Long user_Id, String projectTitle, String projectRole, List<String> techstack, String projectLink,
			String description) {
		super();
		User_Id = user_Id;
		ProjectTitle = projectTitle;
		ProjectRole = projectRole;
		Techstack = techstack;
		ProjectLink = projectLink;
		Description = description;
	}

	public Long getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(Long user_Id) {
		User_Id = user_Id;
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

}
