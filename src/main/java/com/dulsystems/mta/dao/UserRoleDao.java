package com.dulsystems.mta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.bean.UserRoleBean;
import com.dulsystems.mta.dao.mapper.QuoteDetailMapper;
import com.dulsystems.mta.dao.mapper.UserInnerRolesMapper;
import com.dulsystems.mta.dao.mapper.UserMapper;
import com.dulsystems.mta.dao.mapper.UserRoleMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class UserRoleDao implements IUserRoleDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	//METHODS FOR USER AUTH & USER
	@Override
	public UserBean searchUserByUserOrMecId(String user, Integer userMecId) {
		try {
			UserBean ub = null;
			if(user != null) {
				ub = jdbcTemplate.queryForObject(Queries.Q_USERS_SEARCH_BY_USER, new UserMapper(), user);
			}
			if(userMecId != null) {
				ub = jdbcTemplate.queryForObject(Queries.Q_USERS_SEARCH_BY_USER_MEC_ID, new UserMapper(), userMecId);
			}
			return ub;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	//METHODS FOR USER
	@Override
	public boolean executeSaveUser(RequestBean request) {
		boolean bin = false;
		request.setUserMecId(String.valueOf(jdbcTemplate.queryForObject(Queries.Q_USERS_SEARCH_MAX_MEC_ID, Integer.class).intValue()+1));
		int result = jdbcTemplate.update(Queries.Q_USERS_SAVE, new Object[] { request.getUserPk(), request.getUserPassword(), request.getUserName(), request.getUserMecId(), request.getUserPosition(), request.getUserEmail(), request.getUserLocked(), request.getUserDisabled() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateUserByUserForAdmin(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USERS_UPDATE_ALL_EXCEPT_USER_PASSWORD_MECID_AND_EMAIL_BY_USER, new Object[] { request.getUserName(), request.getUserPosition(), request.getUserLocked(), request.getUserDisabled(), request.getUserPk() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}
	
	@Override
	public boolean executeUpdatePasswordForAccountOwner(RequestBean request, String user) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USERS_UPDATE_PASSWORD_BY_USER, new Object[] { request.getMyUserPassword(), user });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}
	
	@Override
	public boolean executeUpdateEmailForAccountOwner(RequestBean request, String user) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USERS_UPDATE_EMAIL_BY_USER, new Object[] { request.getMyUserEmail(), user });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeUserByUser(String user) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USERS_REMOVE_BY_USER, user);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

	//METHODS FOR USER ROLES
	@Override
	public List<String> searchUserRolesByUserMethodTwo(String user) {
		try {
			List<String> roles = jdbcTemplate.queryForList(Queries.Q_USER_ROLES_SEARCH_ALL_ROLES,String.class, user);
			return roles;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public UserRoleBean searchUserRoleByRoleAndUser(RequestBean request) {
		try {
			UserRoleBean urb = jdbcTemplate.queryForObject(Queries.Q_USER_ROLES_SEARCH_BY_ROLE_AND_USER, new UserRoleMapper(), new Object[] { request.getRoleUserPk(),request.getUserPkFk() });;
			return urb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public UserRoleBean searchUserRoleByRoleAndUserMethodTwo(String role, RequestBean request) {
		try {
			UserRoleBean urb = jdbcTemplate.queryForObject(Queries.Q_USER_ROLES_SEARCH_BY_ROLE_AND_USER, new UserRoleMapper(), new Object[] { role,request.getUserPkFk() });;
			return urb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public boolean executeSaveUserRole(String role, RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USER_ROLES_SAVE, new Object[] { role,request.getUserPkFk(),request.getRoleUserGrantedDate() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeUserRoleByRoleAndUser(String role, RequestBean request) {
		System.out.println("REMOVE ROLE: "+role +". OF USER: "+request.getUserPkFk());
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USER_ROLES_REMOVE_BY_ROLE_AND_USER, new Object[] { role, request.getUserPkFk() } );
		if (result > 0) {
            bin = true;
        }
		return bin;
	}
	
	//METHODS FOR INNER OPERATIONS WITH USERS & USERS ROLE TABLES
	@Override
	public List<UserBean> searchUserRolesByUser(String user) {
		try {
			List<UserBean> lub = jdbcTemplate.query(Queries.Q_USERS_INNER_USER_ROLES_BY_USER, new UserInnerRolesMapper(), user);
			return lub;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

}
