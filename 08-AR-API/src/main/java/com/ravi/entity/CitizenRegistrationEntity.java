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
@Table(name = "Citizen_Registration_Info")
public class CitizenRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseNumber;
	
	private String citizenName;
	private String citizenEmial;
	private Long citizenMobileNumber;
	private String citizenGender;
	private LocalDate citizeDob;
	private Long citizenSsn;
	private Integer createdBy;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate creationDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;

	public Integer getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(Integer caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenEmial() {
		return citizenEmial;
	}

	public void setCitizenEmial(String citizenEmial) {
		this.citizenEmial = citizenEmial;
	}

	public Long getCitizenMobileNumber() {
		return citizenMobileNumber;
	}

	public void setCitizenMobileNumber(Long citizenMobileNumber) {
		this.citizenMobileNumber = citizenMobileNumber;
	}

	public String getCitizenGender() {
		return citizenGender;
	}

	public void setCitizenGender(String citizenGender) {
		this.citizenGender = citizenGender;
	}

	public LocalDate getCitizeDob() {
		return citizeDob;
	}

	public void setCitizeDob(LocalDate citizeDob) {
		this.citizeDob = citizeDob;
	}

	public Long getCitizenSsn() {
		return citizenSsn;
	}

	public void setCitizenSsn(Long citizenSsn) {
		this.citizenSsn = citizenSsn;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	
}
