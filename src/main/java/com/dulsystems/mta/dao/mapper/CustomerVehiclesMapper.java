package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.VehicleBean;

public class CustomerVehiclesMapper implements RowMapper<VehicleBean>{

	@Override
	public VehicleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleBean vb = new VehicleBean();
		vb.setVehicleId(rs.getInt("id_vehiculo_pk"));
		vb.setVehicleColor(rs.getString("color"));
		vb.setVehiclePlate(rs.getString("placas"));
		vb.setVehicleMillage(rs.getInt("kilometraje_inicial"));
		vb.setVehicleLineNameFk(rs.getString("marca"));
		vb.setVehicleModelNameFk(rs.getString("modelo"));
		vb.setVehicleYearValueFk(rs.getInt("c_year"));
		return vb;
	}

}