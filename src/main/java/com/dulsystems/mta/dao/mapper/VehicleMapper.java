package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.VehicleBean;

public class VehicleMapper implements RowMapper<VehicleBean>{

	@Override
	public VehicleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleBean vb = new VehicleBean();
		vb.setVehicleId(rs.getInt("id_vehiculo_pk"));
		vb.setVehicleColor(rs.getString("color"));
		vb.setVehiclePlate(rs.getString("placas"));
		vb.setVehicleMillage(rs.getInt("kilometraje_inicial"));
		vb.setCustomerIdFk(rs.getInt("id_cliente_fk"));
		vb.setCustomerNameFk(rs.getString("nombre"));
		vb.setVehicleLineIdFk(rs.getInt("id_marca_fk"));
		vb.setVehicleLineNameFk(rs.getString("marca"));
		vb.setVehicleModelIdFk(rs.getInt("id_modelo_fk"));
		vb.setVehicleModelNameFk(rs.getString("modelo"));
		vb.setVehicleYearIdFk(rs.getInt("id_c_years_fk"));
		vb.setVehicleYearValueFk(rs.getInt("c_year"));
		return vb;
	}

}
