package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.VehicleModelBean;

public class VehicleModelMapper implements RowMapper<VehicleModelBean>{

	@Override
	public VehicleModelBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleModelBean vmb = new VehicleModelBean();
		vmb.setVehicleModelId(rs.getInt("id_modelo_pk"));
		vmb.setVehicleModelName(rs.getString("modelo"));
		vmb.setVehicleLineIdFk(rs.getInt("id_marca_fk"));
		return vmb;
	}

}
