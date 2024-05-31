package com.dulsystems.mta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.bean.UserRoleBean;
import com.dulsystems.mta.dao.mapper.UserInnerRolesMapper;
import com.dulsystems.mta.dao.mapper.UserMapper;
import com.dulsystems.mta.dao.mapper.UserRoleMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class UserRoleDao implements IUserRoleDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	//METHODS FOR USER
	@Override
	public UserBean searchUserByUser(String user) {
		try {
			UserBean ub = jdbcTemplate.queryForObject(Queries.Q_USERS_SEARCH_BY_USER_1, new UserMapper(), user);
			return ub;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveUser(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USERS_SAVE, new Object[] { request.getUserPk(), request.getUserPassword(), request.getUserName(), request.getUserPosition(), request.getUserEmail(), request.getUserLocked(), request.getUserDisabled() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateUserByUser(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USERS_UPDATE_ALL_EXCEPT_USER_PASSWORD_AND_EMAIL_BY_USER, new Object[] { request.getUserPk(), request.getUserName(), request.getUserPosition(), request.getUserLocked(), request.getUserDisabled(), request.getUserPk() });
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
	public UserRoleBean searchUserRoleByRoleAndUser(RequestBean request) {
		try {
			UserRoleBean urb = jdbcTemplate.queryForObject(Queries.Q_USER_ROLES_SEARCH_BY_ROLE_AND_USER, new UserRoleMapper(), new Object[] { request.getRoleUserPk(), request.getUserPkFk() } );
			return urb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveUserRole(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USER_ROLES_SAVE, new Object[] { request.getRoleUserPk(),request.getUserPkFk(),request.getRoleUserGrantedDate() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateUserRoleByRoleAndUser(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USER_ROLES_UPDATE_BY_ROLE_AND_USER, new Object[] { request.getRoleUserPk(),request.getUserPkFk(),request.getRoleUserGrantedDate(), request.getRoleUserPk(), request.getUserPkFk() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeUserRoleByRoleAndUser(RequestBean request) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_USER_ROLES_REMOVE_BY_ROLE_AND_USER, new Object[] { request.getRoleUserPk(), request.getUserPkFk() } );
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
