package com.ravi.entity;

import java.time.LocalDate;

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
	private Integer correspondenceId;
	
	private String noticeStatus;
	private LocalDate noticePrintDate;
	private String noticeS3Url;
	
	@OneToOne
	@JoinColumn(name = "case_number")
	private CitizenRegistrationEntity citizenRegistration;

	public Integer getCorrespondenceId() {
		return correspondenceId;
	}

	public void setCorrespondenceId(Integer correspondenceId) {
		this.correspondenceId = correspondenceId;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public LocalDate getNoticePrintDate() {
		return noticePrintDate;
	}

	public void setNoticePrintDate(LocalDate noticePrintDate) {
		this.noticePrintDate = noticePrintDate;
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
