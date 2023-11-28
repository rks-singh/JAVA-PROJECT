package com.ravi.binding;

import java.time.LocalDate;

public class CorrespondenceInfo {

	private String plnaName;
	private String planStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double benefitAmount;
	private LocalDate generatedDate;
	private String denialResion;
	public String getPlnaName() {
		return plnaName;
	}
	public void setPlnaName(String plnaName) {
		this.plnaName = plnaName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Double getBenefitAmount() {
		return benefitAmount;
	}
	public void setBenefitAmount(Double benefitAmount) {
		this.benefitAmount = benefitAmount;
	}
	public LocalDate getGeneratedDate() {
		return generatedDate;
	}
	public void setGeneratedDate(LocalDate generatedDate) {
		this.generatedDate = generatedDate;
	}
	public String getDenialResion() {
		return denialResion;
	}
	public void setDenialResion(String denialResion) {
		this.denialResion = denialResion;
	}
	
	
}
