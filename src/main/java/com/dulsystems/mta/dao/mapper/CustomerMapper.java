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
		cb.setCustomerName(rs.getString("nombre"));
		cb.setCustomerPrivateEnterprise(rs.getBoolean("particular_o_empresa"));
		cb.setCustomerReference(rs.getString("referencia"));
		cb.setCustomerRfcKey(rs.getString("rfc"));
		cb.setCustomerCp(rs.getString("cp"));
		cb.setCustomerEmail(rs.getString("email"));
		cb.setCustomerPhoneNumber(rs.getString("telefono"));
		cb.setCustomerStateIdFk(rs.getInt("id_estado_fk"));
		cb.setCustomerStateNameFk(rs.getString("estado"));
		cb.setCustomerMunicipalityIdFk(rs.getInt("id_municipio_fk"));
		cb.setCustomerMunicipalityNameFk(rs.getString("municipio"));
		return cb;

	}

}