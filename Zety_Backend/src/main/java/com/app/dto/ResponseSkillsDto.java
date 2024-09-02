package com.app.dto;

import java.util.List;

import com.app.entity.SkillType;

public class ResponseSkillsDto {
	
	private int id;
	private List<String> skills;
	private SkillType skillType;
	private String languages;

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public String getLanguages() {
		return languages;
		
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
