package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.UserBean;
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

	@Override
	public boolean executeSaveUser(RequestBean request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean executeUpdateUserByUsername(RequestBean request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
