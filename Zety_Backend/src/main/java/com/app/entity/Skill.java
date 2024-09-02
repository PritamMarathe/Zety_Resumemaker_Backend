package com.app.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
public class Skill extends BaseEntity {

    @ElementCollection
    @CollectionTable(name = "skills_list", joinColumns = @JoinColumn(name = "skill_id"))
    @Column(name = "skill")
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_type")
    private SkillType skillType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private BasicDetails detailsSkill;
    
    @Column(name = "languages", columnDefinition = "TEXT")
    @Size(max = 65534, message = "Languages cannot exceed 65,534 characters")
    private String languages;

    public Skill() {}
    
	public Skill(List<String> skills, SkillType skillType, String languages) {
		super();
		this.skills = skills;
		this.skillType = skillType;
		this.languages = languages;
	}

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

	public BasicDetails getDetailsSkill() {
		return detailsSkill;
	}

	public void setDetailsSkill(BasicDetails detailsSkill) {
		this.detailsSkill = detailsSkill;
	}

	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}


	@Override
	public String toString() {
		return "Skill [skills=" + skills + ", skillType=" + skillType + ", detailsSkill=" + detailsSkill
				+ ", languages=" + languages + "]";
	}

}
