package com.ravi.request;

import java.time.LocalDate;

public class SignUpRequest {

	private String name;
	private String email;
	private String password;
	private String gender;
	private LocalDate dob;
	private Long phno;
	private Long ssn;
	private String userType;
	private String isPasswordChanged;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public Long getSsn() {
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getIsPasswordChanged() {
		return isPasswordChanged;
	}
	public void setIsPasswordChanged(String isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}
	
	
}
