package com.ravi.binding;

public class Income {

	private Integer userId;
	private Integer caseNumber;
	private Double monthlySalaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	
	
	
	public Integer getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(Integer caseNumber) {
		this.caseNumber = caseNumber;
	}
	public Double getMonthlySalaryIncome() {
		return monthlySalaryIncome;
	}
	public void setMonthlySalaryIncome(Double monthlySalaryIncome) {
		this.monthlySalaryIncome = monthlySalaryIncome;
	}
	public Double getRentIncome() {
		return rentIncome;
	}
	public void setRentIncome(Double rentIncome) {
		this.rentIncome = rentIncome;
	}
	public Double getPropertyIncome() {
		return propertyIncome;
	}
	public void setPropertyIncome(Double propertyIncome) {
		this.propertyIncome = propertyIncome;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
