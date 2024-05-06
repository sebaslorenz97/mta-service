package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.VehicleYearBean;

public class VehicleYearMapper implements RowMapper<VehicleYearBean>{

	@Override
	public VehicleYearBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleYearBean vyb = new VehicleYearBean();
		vyb.setVehicleYearId(rs.getInt("id_c_year_pk"));
		vyb.setVehicleYearValue(rs.getInt("c_year"));
		return vyb;
	}
	
}
