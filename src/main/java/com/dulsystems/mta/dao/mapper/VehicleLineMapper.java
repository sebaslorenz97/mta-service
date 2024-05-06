package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.VehicleLineBean;

public class VehicleLineMapper implements RowMapper<VehicleLineBean> {

	@Override
	public VehicleLineBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleLineBean vlb = new VehicleLineBean();
		vlb.setVehicleLineId(rs.getInt("id_marca_pk"));
		vlb.setVehicleLineName(rs.getString("marca"));
		return vlb;
	}

}