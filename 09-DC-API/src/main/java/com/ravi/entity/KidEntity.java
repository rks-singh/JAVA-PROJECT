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
@Table(name = "Kids_Info")
public class KidEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer kidId;
	private String kidName;
	private Integer kidAge;
	private Long kidSsn;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToOne
	@JoinColumn(name = "case_number")
	private CitizenRegistrationEntity citizenRegistration;
	
	public Integer getKidId() {
		return kidId;
	}
	public void setKidId(Integer kidId) {
		this.kidId = kidId;
	}
	
	public String getKidName() {
		return kidName;
	}
	public void setKidName(String kidName) {
		this.kidName = kidName;
	}
	public Integer getKidAge() {
		return kidAge;
	}
	public void setKidAge(Integer kidAge) {
		this.kidAge = kidAge;
	}
	public Long getKidSsn() {
		return kidSsn;
	}
	public void setKidSsn(Long kidSsn) {
		this.kidSsn = kidSsn;
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