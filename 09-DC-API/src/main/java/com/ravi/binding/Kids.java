package com.ravi.binding;

import java.util.List;

public class Kids {

	private Integer userId;
	private Integer caseNumber;
	private List<Kid> kids;
	
	public Integer getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(Integer caseNumber) {
		this.caseNumber = caseNumber;
	}
	public List<Kid> getKids() {
		return kids;
	}
	public void setKids(List<Kid> kids) {
		this.kids = kids;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
