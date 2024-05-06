package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.VehicleBean;

public class VehicleMapper implements RowMapper<VehicleBean>{

	@Override
	public VehicleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		VehicleBean vb = new VehicleBean();
		vb.setId(rs.getInt("id_vehiculo_pk"));
		vb.setColor(rs.getString("color"));
		vb.setPlates(rs.getString("placas"));
		vb.setMileage(rs.getInt("kilometraje_inicial"));
		vb.setCustomerIdFk(rs.getInt("id_cliente_fk"));
		vb.setVehicleLineIdFk(rs.getInt("id_marca_fk"));
		vb.setModelIdFk(rs.getInt("id_modelo_fk"));
		vb.setcYearIdFk(rs.getInt("id_c_years_fk"));
		return vb;
	}

}
