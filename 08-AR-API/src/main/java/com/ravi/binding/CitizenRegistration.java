package com.ravi.binding;

import java.time.LocalDate;

public class CitizenRegistration {

	private Integer caseNumber;
	private String citizenName;
	private String citizenEmial;
	private Long citizenMobileNumber;
	private String citizenGender;
	private LocalDate citizeDob;
	private Long citizenSsn;
	private Integer createdBy;
	
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
	
}
