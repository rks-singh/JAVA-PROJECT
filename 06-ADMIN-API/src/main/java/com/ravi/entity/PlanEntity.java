package com.ravi.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plan_Info")
public class PlanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String planName;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String planCategory;
	private String activeSwitch;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate creationDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updationDate;
	
	public PlanEntity() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getUpdationDate() {
		return updationDate;
	}

	public void setUpdationDate(LocalDate updationDate) {
		this.updationDate = updationDate;
	}

	public String getActiveSwitch() {
		return activeSwitch;
	}

	public void setActiveSwitch(String activeSwitch) {
		this.activeSwitch = activeSwitch;
	}
	
	

}
