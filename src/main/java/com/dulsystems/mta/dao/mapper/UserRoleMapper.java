package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.UserRoleBean;


public class UserRoleMapper implements RowMapper<UserRoleBean>{

	@Override
	public UserRoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRoleBean urb = new UserRoleBean();
		urb.setRoleUserPk(rs.getString("role_user_pk"));
		urb.setRoleUserGrantedDate(rs.getString("username_fk"));
		urb.setUserPkFk(rs.getString("granted_date"));
		return urb;
	}

}
