package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.bean.UserRoleBean;

public interface IUserRoleDao {
	
	//METHODS FOR USER
	UserBean searchUserByUser(String user);
	boolean executeSaveUser(RequestBean request);
	boolean executeUpdateUserByUserForAdmin(RequestBean request);
	boolean removeUserByUser(String user);
		
	//METHODS FOR USER ROLES
	List<String> searchAllUserRoles(RequestBean request);
	boolean executeSaveUserRole(RequestBean request);
	boolean executeUpdateUserRoleByRoleAndUser(RequestBean request);
	boolean removeUserRoleByRoleAndUser(RequestBean request);
		
	//METHODS FOR INNER OPERATIONS WITH USERS ROLE
	List<UserBean> searchUserRolesByUser(String user);

}
