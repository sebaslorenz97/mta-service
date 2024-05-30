package com.dulsystems.mta.bean;

public class UserBean {
	
	//REQUEST FIELDS FOR LOGIN & USER
	private String userPk;
	private String userPassword;
	//REQUEST FIELDS FOR USER
	private String userName;
	private String userPosition;
	private String userEmail;
	private Boolean userLocked;
	private Boolean userDisabled;
	
	//REQUEST FIELDS FOR INNER OPERATIONS WITH USERS ROLE
	private String roleUser;
	private String roleUserGrantedDate;
	
	public String getUserPk() {
		return userPk;
	}
	public void setUserPk(String userPk) {
		this.userPk = userPk;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
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
	
	//GETTER & SETTERS FOR INNER OPERATIONS WITH USERS ROLE
	public String getRoleUser() {
		return roleUser;
	}
	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}
	public String getRoleUserGrantedDate() {
		return roleUserGrantedDate;
	}
	public void setRoleUserGrantedDate(String roleUserGrantedDate) {
		this.roleUserGrantedDate = roleUserGrantedDate;
	}
	
}
