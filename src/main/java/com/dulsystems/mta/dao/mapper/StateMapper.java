package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.StateBean;

public class StateMapper implements RowMapper<StateBean> {

	@Override
	public StateBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		StateBean sb = new StateBean();
		sb.setStateId(rs.getInt("id_estado_pk"));
		sb.setStateName(rs.getString("estado"));
		return sb;
	}

}
