package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.UserBean;

public class UserMapper implements RowMapper<UserBean>{

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean ub = new UserBean();
		ub.setUserName(rs.getString("username_pk"));
		ub.setUserPassword(rs.getString("passwordd"));
		ub.setUserEmail(rs.getString("email"));
		ub.setUserEmail(rs.getString("email"));
		ub.setUserEmail(rs.getString("email"));
		ub.setUserLocked(rs.getBoolean("lockedd"));
		ub.setUserDisabled(rs.getBoolean("disabled"));
		return ub;
	}

}
