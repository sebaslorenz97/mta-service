package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.QuoteDetailBean;

public class QuoteDetailMapper implements RowMapper<QuoteDetailBean>{

	@Override
	public QuoteDetailBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuoteDetailBean qdb = new QuoteDetailBean();
		qdb.setQuoteDetailId(rs.getInt("id_cotizacion_detalle_pk"));
		qdb.setQuoteDetailMecId(rs.getInt("mec"));
		qdb.setQuoteDetailLabour(rs.getString("mano_obra_refacciones"));
		qdb.setQuoteDetailAmount(rs.getInt("importe"));
		qdb.setQuoteDetailIdFk(rs.getInt("id_cotizacion_fk"));
		return qdb;
	}
	

}
