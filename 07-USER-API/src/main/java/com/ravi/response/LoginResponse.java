package com.ravi.response;

public class LoginResponse {

	private Integer userId;
	private String name;
	private String userType;
	private Boolean isValidLogin;
	private String isPasswordChanged;
	private DashBoardResponse dashBoardResponse;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public DashBoardResponse getDashBoardResponse() {
		return dashBoardResponse;
	}
	public void setDashBoardResponse(DashBoardResponse dashBoardResponse) {
		this.dashBoardResponse = dashBoardResponse;
	}
	public Boolean getIsValidLogin() {
		return isValidLogin;
	}
	public void setIsValidLogin(Boolean isValidLogin) {
		this.isValidLogin = isValidLogin;
	}
	public String getIsPasswordChanged() {
		return isPasswordChanged;
	}
	public void setIsPasswordChanged(String isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}

}
