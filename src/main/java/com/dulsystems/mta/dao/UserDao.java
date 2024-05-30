package com.dulsystems.mta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.dao.mapper.UserInnerRolesMapper;
import com.dulsystems.mta.dao.mapper.UserMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class UserDao implements IUserDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public UserBean searchUserByUsername(String userName) {
		try {
			UserBean ub = jdbcTemplate.queryForObject(Queries.Q_USERS_SEARCH_BY_USERNAME, new UserMapper(), userName);
			return ub;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	//METHODS FOR INNER OPERATIONS WITH USERS ROLE
	@Override
	public List<UserBean> searchUserRolesByUsername(String userName) {
		try {
			List<UserBean> lub = jdbcTemplate.query(Queries.Q_USERS_INNER_USERS_ROLE_BY_USERNAME, new UserInnerRolesMapper(), userName);
			return lub;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

}
