package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.CustomerBean;

public class CustomerMapper implements RowMapper<CustomerBean>{

	@Override
	public CustomerBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomerBean cb = new CustomerBean();
		cb.setCustomerId(rs.getInt("id_cliente_pk"));
		cb.setName(rs.getString("nombre"));
		cb.setPrivateEnterprise(rs.getBoolean("particular_o_empresa"));
		cb.setReference(rs.getString("referencia"));
		cb.setRfcKey(rs.getString("rfc"));
		cb.setCp(rs.getString("cp"));
		cb.setEmail(rs.getString("email"));
		cb.setPhoneNumber(rs.getString("telefono"));
		cb.setStateIdFk(rs.getInt("id_estado_fk"));
		cb.setMunicipalityIdFk(rs.getInt("id_municipio_fk"));
		return cb;

	}

}