package com.app.entity;

import java.time.LocalDate;
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


@Entity
@Table(name="education")
public class Education extends BaseEntity{
	
	 
	@Column(name = "school_name")
	private String SchoolName;

	@Column(name = "schooll_ocation")
	private String SchoolLocation;
	
	@Column(name = "field_of_study")
	private String FieldOfStudy;
	
	@Column(name = "graduation_Year")
	private String graduationYear;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "degree")
	private Degree degree;
	
	@Enumerated(EnumType.STRING)
	@Column(name="month")
	private Months month;
	
    @Column(name = "is_gap_taken")
	private boolean isGapTaken;
    
    @Column(name = "gap_year")
	private String gapYear;
	
	@ElementCollection
	@CollectionTable(name = "certification", joinColumns = @JoinColumn(name = "education_id"))
	@Column(name = "certification_name")
	private List<String> certification;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=false)
	private BasicDetails detailsEducation;
	
	public Education() {}
	
	public Education(String schoolName, String schoolLocation, String fieldOfStudy, String graduationYear,
			Degree degree, Months month, boolean isGapTaken, String gapYear, List<String> certification,
			BasicDetails detailsEducation) {
		SchoolName = schoolName;
		SchoolLocation = schoolLocation;
		FieldOfStudy = fieldOfStudy;
		this.graduationYear = graduationYear;
		this.degree = degree;
		this.month = month;
		this.isGapTaken = isGapTaken;
		this.gapYear = gapYear;
		this.certification = certification;
		this.detailsEducation = detailsEducation;
	}




	public String getSchoolName() {
		return SchoolName;
	}

	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;

	}

	public String getSchoolLocation() {
		return SchoolLocation;
	}

	public void setSchoolLocation(String schoolLocation) {
		SchoolLocation = schoolLocation;
	}

	public String getFieldOfStudy() {
		return FieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		FieldOfStudy = fieldOfStudy;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public BasicDetails getDetailsEducation() {
		return detailsEducation;
	}

	public void setDetailsEducation(BasicDetails detailsEducation) {
		this.detailsEducation = detailsEducation;
	}

	public Months getMonth() {
		return month;
	}

	public void setMonth(Months month) {
		this.month = month;
	}
	
	public boolean isGapTaken() {
		return isGapTaken;
	}

	public void setGapTaken(boolean isGapTaken) {
		this.isGapTaken = isGapTaken;
	}

	public String getGapYear() {
		return gapYear;
	}

	public void setGapYear(String gapYear) {
		this.gapYear = gapYear;
	}

	public List<String> getCertification() {
		return certification;
	}

	public void setCertification(List<String> certification) {
		this.certification = certification;
	}

	@Override
	public String toString() {
		return "Education [ SchoolName=" + SchoolName + ", SchoolLocation=" + SchoolLocation
				+ ", FieldOfStudy=" + FieldOfStudy + ", graduationYear=" + graduationYear + ", degree=" + degree
				+ ", month=" + month + ", isGapTaken=" + isGapTaken + ", gapYear=" + gapYear + ", certification="
				+ certification + ", detailsEducation=" + detailsEducation + "]";
	}

}
