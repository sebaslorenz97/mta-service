package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;

public interface IUserDao {
	
	UserBean searchUserByUsername(String userName);
	
	boolean executeSaveUser(RequestBean request);
	
	boolean executeUpdateUserByUsername(RequestBean request);
	
	boolean removeUserByUsername(String userName);

}
