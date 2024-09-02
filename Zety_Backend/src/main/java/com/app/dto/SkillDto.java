package com.app.dto;

import java.util.List;

import com.app.entity.SkillType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SkillDto {
	
	 private List<String> skills;
	 private SkillType skillType;
	 private Long userId;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	
}
