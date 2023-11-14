package com.ravi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "correspondence_Info")
public class CorrespondenceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer correspondenceEntity;
	
	private String noticeStatus;
	private String noticeGeneratedInfo;
	private String noticeS3Url;
	
	@OneToOne
	@JoinColumn(name = "case_number")
	private CitizenRegistrationEntity citizenRegistration;

	public Integer getCorrespondenceEntity() {
		return correspondenceEntity;
	}

	public void setCorrespondenceEntity(Integer correspondenceEntity) {
		this.correspondenceEntity = correspondenceEntity;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public String getNoticeGeneratedInfo() {
		return noticeGeneratedInfo;
	}

	public void setNoticeGeneratedInfo(String noticeGeneratedInfo) {
		this.noticeGeneratedInfo = noticeGeneratedInfo;
	}

	public String getNoticeS3Url() {
		return noticeS3Url;
	}

	public void setNoticeS3Url(String noticeS3Url) {
		this.noticeS3Url = noticeS3Url;
	}

	public CitizenRegistrationEntity getCitizenRegistration() {
		return citizenRegistration;
	}

	public void setCitizenRegistration(CitizenRegistrationEntity citizenRegistration) {
		this.citizenRegistration = citizenRegistration;
	}
	
	
	
}
