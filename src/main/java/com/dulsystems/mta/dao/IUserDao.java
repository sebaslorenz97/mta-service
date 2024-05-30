package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;

public interface IUserDao {
	
	UserBean searchUserByUsername(String userName);
	
	//METHODS FOR INNER OPERATIONS WITH USERS ROLE
	List<UserBean> searchUserRolesByUsername(String userName);

}
