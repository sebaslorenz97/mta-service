package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.bean.UserRoleBean;

public interface IUserRoleDao {
	
	//METHODS FOR USER
	UserBean searchUserByUserOrMecId(String user, Integer userMecId);
	boolean executeSaveUser(RequestBean request);
	boolean executeUpdateUserByUserForAdmin(RequestBean request);
	boolean executeUpdatePasswordForAccountOwner(RequestBean request, String user);
	boolean executeUpdateEmailForAccountOwner(RequestBean request, String user);
	boolean removeUserByUser(String user);
		
	//METHODS FOR USER ROLES
	List<String> searchUserRolesByUserMethodTwo(String user);
	UserRoleBean searchUserRoleByRoleAndUser(RequestBean request);
	UserRoleBean searchUserRoleByRoleAndUserMethodTwo(String role, RequestBean request);
	boolean executeSaveUserRole(String role, RequestBean request);
	//boolean executeUpdateUserRoleByRoleAndUser(RequestBean request);
	boolean removeUserRoleByRoleAndUser(String role, RequestBean request);
		
	//METHODS FOR INNER OPERATIONS WITH USERS ROLE
	List<UserBean> searchUserRolesByUser(String user);

}
