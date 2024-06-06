package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.MunicipalityBean;

public class MunicipalityMapper implements RowMapper<MunicipalityBean>{

	@Override
	public MunicipalityBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		MunicipalityBean mb = new MunicipalityBean();
		mb.setMunicipalityId(rs.getInt("municipios.id_municipio_pk"));
		mb.setMunicipalityName(rs.getString("municipios.municipio"));
		mb.setStateIdFk(rs.getInt("municipios.id_estado_fk"));
		return mb;
	}

}
