package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.UserBean;

public class UserInnerRolesMapper implements RowMapper<UserBean>{

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean ub = new UserBean();
		ub.setUserPk(rs.getString("username_pk"));
		ub.setRoleUser(rs.getString("role_user_pk"));
		ub.setRoleUserGrantedDate(rs.getString("granted_date"));
		return ub;
	}

}
