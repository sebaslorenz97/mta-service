package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IUserRoleService {
	
	//METHODS FOR USER
	ResponseBean searchUserByUser(String user);
	ResponseBean executeSaveUser(RequestBean request);
	ResponseBean executeUpdateUserByUser(RequestBean request);
	ResponseBean removeUserByUser(String user);
		
	//METHODS FOR USER ROLES
	ResponseBean searchUserRoleByRoleAndUser(RequestBean request);
	ResponseBean executeSaveUserRole(RequestBean request);
	ResponseBean executeUpdateUserRoleByRoleAndUser(RequestBean request);
	ResponseBean removeUserRoleByRoleAndUser(RequestBean request);

}
