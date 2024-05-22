package com.dulsystems.mta.bean;

public class UserBean {
	
	//FIELDS FOR USERS
	private String userName;
	private String userPassword;
	private String userEmail;
	private Boolean userLocked;
	private Boolean userDisabled;
	
	//REQUEST FIELDS FOR INNER OPERATIONS WITH USERS ROLE
	private String userRole;
	private String userRoleGrantedDate;
	
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
	
	//GETTER & SETTERS FOR INNER OPERATIONS WITH USERS ROLE
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserRoleGrantedDate() {
		return userRoleGrantedDate;
	}
	public void setUserRoleGrantedDate(String userRoleGrantedDate) {
		this.userRoleGrantedDate = userRoleGrantedDate;
	}

	
}
