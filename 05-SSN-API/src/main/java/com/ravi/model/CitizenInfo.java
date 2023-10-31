package com.ravi.model;

import java.time.LocalDate;

public class CitizenInfo {

	String name;
	LocalDate dob;
	String gender;
	String SSN;
	String stateName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	@Override
	public String toString() {
		return "CitizenInfo [name=" + name + ", dob=" + dob + ", gender=" + gender + ", SSN=" + SSN + ", stateName="
				+ stateName + "]";
	}
}
