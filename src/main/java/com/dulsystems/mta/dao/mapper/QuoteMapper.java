package com.dulsystems.mta.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dulsystems.mta.bean.QuoteBean;

public class QuoteMapper implements RowMapper<QuoteBean>{

	@Override
	public QuoteBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuoteBean qb = new QuoteBean();
		qb.setQuoteId(rs.getInt("id_cotizacion_pk"));
		qb.setQuoteOrderDate(rs.getString("fecha_orden"));
		qb.setQuoteDeadline(rs.getString("fecha_entrega"));
		qb.setQuoteStatusVehicle(rs.getBoolean("estatus_auto"));
		qb.setQuotePaymentMethod(rs.getBoolean("metodo_pago"));
		qb.setQuotePaymentStatus(rs.getBoolean("estatus_pago"));
		qb.setQuoteAdvancePayment(rs.getInt("adelanto_pago"));
		qb.setQuoteRequireInvoice(rs.getBoolean("factura"));
		qb.setVehicleIdFk(rs.getInt("id_vehiculo_fk"));
		return qb;
	}

}
