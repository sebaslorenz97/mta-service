package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IUserRoleService {
	
	//METHODS FOR USER
	ResponseBean searchUserByUserOrMecId(String user, Integer mecId);
	ResponseBean executeSaveUser(RequestBean request);
	ResponseBean executeUpdateUserByUserForAdmin(RequestBean request);
	ResponseBean executeUpdatePasswordForAccountOwner(RequestBean request);
	ResponseBean executeUpdateEmailForAccountOwner(RequestBean request);
	ResponseBean removeUserByUser(String user);
		
	//METHODS FOR USER ROLES
	ResponseBean searchUserRolesByUser(String user);
	ResponseBean executeSaveUserRoles(RequestBean request);
	//ResponseBean executeUpdateUserRoleByRoleAndUser(RequestBean request);
	//ResponseBean removeUserRoleByRoleAndUser(RequestBean request);

}
