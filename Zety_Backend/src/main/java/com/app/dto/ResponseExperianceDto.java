package com.app.dto;

import java.time.LocalDate;
import java.util.List;

public class ResponseExperianceDto {
	
	private int id;
	private String Title;
	private String Company;
	private String Location;
	private LocalDate StartDate;
	private LocalDate EndDate;
	private List<String> responsibility;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getEndDate() {
		return EndDate;
	}

	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}

	public List<String> getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(List<String> responsibility) {
		this.responsibility = responsibility;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
