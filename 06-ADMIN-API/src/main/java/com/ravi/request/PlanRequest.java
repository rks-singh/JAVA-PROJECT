package com.ravi.request;

import java.time.LocalDate;

public class PlanRequest {

	private String planName;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String planCategory;

	public PlanRequest() {}
	
	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanCategory() {
		return planCategory;
	}

	public void setPlanCategory(String planCategory) {
		this.planCategory = planCategory;
	}
	
	
}
