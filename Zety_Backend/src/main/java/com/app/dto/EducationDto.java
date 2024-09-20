package com.app.dto;

import java.util.List;
import com.app.entity.Degree;
import com.app.entity.Months;

public class EducationDto {
	
	private int id;
	private String SchoolName;
	private String SchoolLocation;
	private String FieldOfStudy;
	private String graduationYear;
	private Degree degree;
    private Long userId;
    private Months month;
    private boolean isGapTaken;
    private String gapYear;
    private List<String>certification;
	
	public EducationDto() {
		super();
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
