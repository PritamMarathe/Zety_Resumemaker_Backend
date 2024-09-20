package com.app.dto;

import java.util.List;




public class CombinedResponseDto {
	
	private ResponseBesicDetailsDto besicDetails;
	
	private List<ResponseEducationDto> educationList;
	
	private List<ResponseExperianceDto> experianceList;
	
	private List<ResponseSkillsDto> skillList;
	
	private List<ResponseProjectDto> projectList;

	public ResponseBesicDetailsDto getBesicDetails() {
		return besicDetails;
	}

	public void setBesicDetails(ResponseBesicDetailsDto besicDetails) {
		this.besicDetails = besicDetails;
	}

	public List<ResponseEducationDto> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<ResponseEducationDto> educationList) {
		this.educationList = educationList;
	}

	public List<ResponseExperianceDto> getExperianceList() {
		return experianceList;
	}

	public void setExperianceList(List<ResponseExperianceDto> experianceList) {
		this.experianceList = experianceList;
	}

	public List<ResponseSkillsDto> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<ResponseSkillsDto> skillList) {
		this.skillList = skillList;
	}

	public List<ResponseProjectDto> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ResponseProjectDto> projectList) {
		this.projectList = projectList;
	}
	
	
	


	
	
	
	
}
