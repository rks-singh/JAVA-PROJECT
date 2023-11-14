package com.ravi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Income_Info")
public class IncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer incomeId;
	
	private Double monthlySalaryIncome;
	private Double rentIncome;
	private Double propertyIncome;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name = "case_number")
	private CitizenRegistrationEntity citizenRegistration;
	
	public Integer getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
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
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public CitizenRegistrationEntity getCitizenRegistration() {
		return citizenRegistration;
	}
	public void setCitizenRegistration(CitizenRegistrationEntity citizenRegistration) {
		this.citizenRegistration = citizenRegistration;
	}
	
	
	
}
