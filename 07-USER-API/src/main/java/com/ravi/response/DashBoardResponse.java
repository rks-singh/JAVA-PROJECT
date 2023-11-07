package com.ravi.response;

public class DashBoardResponse {

	private Long planCount;
	private Long citizensApprovedCount;
	private Long citizensDeniedCount;
	private Double totalBenifitAmount;
	
	public Long getPlanCount() {
		return planCount;
	}
	public void setPlanCount(Long planCount) {
		this.planCount = planCount;
	}
	public Long getCitizensApprovedCount() {
		return citizensApprovedCount;
	}
	public void setCitizensApprovedCount(Long citizensApprovedCount) {
		this.citizensApprovedCount = citizensApprovedCount;
	}
	public Long getCitizensDeniedCount() {
		return citizensDeniedCount;
	}
	public void setCitizensDeniedCount(Long citizensDeniedCount) {
		this.citizensDeniedCount = citizensDeniedCount;
	}
	public Double getTotalBenifitAmount() {
		return totalBenifitAmount;
	}
	public void setTotalBenifitAmount(Double totalBenifitAmount) {
		this.totalBenifitAmount = totalBenifitAmount;
	}
	
	
}
