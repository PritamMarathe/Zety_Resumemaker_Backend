package com.app.entity;

import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	@Column(name = "title", length = 100)
    @NotEmpty(message = "Project title cannot be empty")
    @Size(max = 100, message = "Project title cannot exceed 100 characters")
    private String projectTitle;

    @Column(name = "role", length = 100)
    @NotEmpty(message = "Project role cannot be empty")
    @Size(max = 100, message = "Project role cannot exceed 100 characters")
    private String projectRole;

    @ElementCollection
    @CollectionTable(name = "tech_stacks", joinColumns = @JoinColumn(name = "project_id"))
    @NotEmpty(message = "Tech stack cannot be empty")
    private List<String> techstack;

    @Column(name = "link", length = 255)
    @Size(max = 255, message = "Project link cannot exceed 255 characters")
    private String projectLink;

    @Column(name = "description", columnDefinition = "TEXT")
    @Size(max = 65534, message = "Description cannot exceed 65,534 characters")
    private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private BasicDetails detailsProject;

	public Project(String projectTitle, String projectRole, List<String> techstack, String projectLink,
			String description, BasicDetails detailsProject) {
		super();
		this.projectTitle = projectTitle;
		this.projectRole = projectRole;
		this.techstack = techstack;
		this.projectLink = projectLink;
		this.description = description;
		this.detailsProject = detailsProject;
	}

	public Project() {
		super();
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public List<String> getTechstack() {
		return this.techstack;
	}

	public void setTechstack(List<String> techstack) {
		this.techstack = techstack;
	}

	public String getProjectLink() {
		return this.projectLink;
	}

	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BasicDetails getDetailsProject() {
		return detailsProject;
	}

	public void setDetailsProject(BasicDetails detailsProject) {
		this.detailsProject = detailsProject;
	}

	@Override
	public String toString() {
		return "Project [ProjectTitle=" + projectTitle + ", ProjectRole=" + projectRole + ", Techstack=" + techstack
				+ ", ProjectLink=" + projectLink + ", Description=" + description + "]";
	}
	
	

}