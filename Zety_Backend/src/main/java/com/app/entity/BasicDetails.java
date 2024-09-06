package com.app.entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "besic_details")
public class BasicDetails extends BaseEntity {

	@Column(name = "first_name", length = 100)
	@NotEmpty(message = "First name cannot be empty")
	@Size(max = 100, message = "First name cannot exceed 100 characters")
	private String firstName;

	@Column(name = "last_name", length = 100)
	@NotEmpty(message = "Last name cannot be empty")
	@Size(max = 100, message = "Last name cannot exceed 100 characters")
	private String lastName;

	@Column(name = "email", length = 100)
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String email;

	@Column(name = "phone", length = 10)
	@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	@NotEmpty(message = "Phone number cannot be empty")
	private String phone;

	@Column(name = "profession", length = 100)
	@NotEmpty(message = "Profession cannot be empty")
	@Size(max = 100, message = "Profession cannot exceed 100 characters")
	private String profession;

	@Column(name = "city", length = 100)
	@NotEmpty(message = "City cannot be empty")
	@Size(max = 100, message = "City cannot exceed 100 characters")
	private String city;

	@Column(name = "country", length = 100)
	@NotEmpty(message = "Country cannot be empty")
	@Size(max = 100, message = "Country cannot exceed 100 characters")
	private String country;

	@Column(name = "linkdin", length = 255)
	@Size(max = 255, message = "LinkedIn URL cannot exceed 255 characters")
	private String linkdin;

	@Column(name = "github", length = 255)
	@Size(max = 255, message = "GitHub URL cannot exceed 255 characters")
	private String github;

	@Column(name = "message", length = 65534, columnDefinition = "TEXT")
	@Size(max = 65534, message = "Message cannot exceed 65,534 characters")
	private String message;
	
	@Lob        //lob(larger object) refers to length datatype for storing larger objects 
	@Column(name="profile_image")
	private byte[] ProfileImage;     //image are stored as binary data in byte[]
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "detailsEducation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Education> education = new ArrayList<>();

	@OneToMany(mappedBy = "detailsExperiance", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experiance> experiance = new ArrayList<>();

	@OneToMany(mappedBy = "detailsSkill", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Skill> skills = new ArrayList<>();

	@OneToMany(mappedBy = "detailsProject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Project> projects = new ArrayList<>();

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	// helper methods
	public void addEducation(Education e) {
		education.add(e);
		e.setDetailsEducation(this);
	}

	public void removeEducation(Education e) {
		education.remove(e);
		e.setDetailsEducation(null);
	}

	// helper method for experiance
	public void addExperance(Experiance e) {
		experiance.add(e);
		e.setDetailsExperiance(this);
	}

	public void removeExperiance(Experiance e) {
		experiance.remove(e);
		e.setDetailsExperiance(null);
	}

	// helper method for Skills
	public void addSkill(Skill s) {
		skills.add(s);
		s.setDetailsSkill(this);
	}

	public void removeSkill(Skill s) {
		skills.remove(s);
		s.setDetailsSkill(null);
	}

	public void addProject(Project p) {
		projects.add(p);
		p.setDetailsProject(this);
	}

	public void removeProject(Project p) {
		projects.remove(p);
		p.setDetailsProject(null);
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLinkdin() {
		return linkdin;
	}

	public void setLinkdin(String linkdin) {
		this.linkdin = linkdin;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Experiance> getExperiance() {
		return experiance;
	}

	public void setExperiance(List<Experiance> experiance) {
		this.experiance = experiance;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getProfileImage() {
		return ProfileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		ProfileImage = profileImage;
	}

	@Override
	public String toString() {
		return "BasicDetails [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", profession=" + profession + ", city=" + city + ", country=" + country + ", linkdin="
				+ linkdin + ", github=" + github + ", message=" + message + ", ProfileImage="
				+ Arrays.toString(ProfileImage) + ", education=" + education + ", experiance=" + experiance
				+ ", skills=" + skills + ", projects=" + projects + ", user=" + user + "]";
	}
}
