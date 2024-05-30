package com.dulsystems.mta.bean;

public class UserRoleBean {
	
	//REQUEST FIELDS FOR INNER OPERATIONS WITH USERS ROLE
	private String roleUserPk;
	private String roleUserGrantedDate;
	private String userPkFk;
	
	public String getRoleUserPk() {
		return roleUserPk;
	}
	public void setRoleUserPk(String roleUserPk) {
		this.roleUserPk = roleUserPk;
	}
	public String getRoleUserGrantedDate() {
		return roleUserGrantedDate;
	}
	public void setRoleUserGrantedDate(String roleUserGrantedDate) {
		this.roleUserGrantedDate = roleUserGrantedDate;
	}
	public String getUserPkFk() {
		return userPkFk;
	}
	public void setUserPkFk(String userPkFk) {
		this.userPkFk = userPkFk;
	}
		
}
