package com.dulsystems.mta.bean;

public class UserBean {
	
	private String userName;
	private String userPassword;
	private String userEmail;
	private Boolean userLocked;
	private Boolean userDisabled;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Boolean getUserLocked() {
		return userLocked;
	}
	public void setUserLocked(Boolean userLocked) {
		this.userLocked = userLocked;
	}
	public Boolean getUserDisabled() {
		return userDisabled;
	}
	public void setUserDisabled(Boolean userDisabled) {
		this.userDisabled = userDisabled;
	}

}
