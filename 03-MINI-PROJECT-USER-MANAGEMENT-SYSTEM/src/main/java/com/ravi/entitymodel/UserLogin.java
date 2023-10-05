package com.ravi.entitymodel;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String email;
	private String password;
	private String accountStatus;
	
	@Transient
	private String tempPwd;
	@Transient
	private String newPwd;
	@Transient
	private String confirmPwd;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate creationDate;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return email;
	}

	public void setUserEmail(String userEmail) {
		this.email = userEmail;
	}

	public String getUserPassword() {
		return password;
	}

	public void setUserPassword(String userPassword) {
		this.password = userPassword;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", userEmail=" + email + ", userPassword=" + password
				+ ", accountStatus=" + accountStatus + ", creationDate=" + creationDate + ", updateDate=" + updateDate
				+ "]";
	}
	
	
}
