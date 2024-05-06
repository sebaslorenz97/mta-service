package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.dao.mapper.CustomerMapper;
import com.dulsystems.mta.dao.mapper.QuoteMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class QuoteDao implements IQuoteDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public QuoteBean searchQuoteById(Integer id) {
		try {
			QuoteBean qb = jdbcTemplate.queryForObject(Queries.Q_QUOTES_SEARCH_BY_ID, new QuoteMapper(), id);
			return qb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public boolean executeSaveQuote(RequestBean request, VehicleBean vb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_QUOTES_SAVE, new Object[] { vb.getId(),request.getQuoteOrderDate(),request.getQuoteDeadline(),request.getQuoteStatusVehicle(),request.getQuotePaymentMethod(),request.getQuotePaymentStatus(),request.getQuoteAdvancePayment(),request.getQuoteRequireInvoice() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateQuoteById(RequestBean request, VehicleBean vb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_QUOTES_UPDATE_BY_ID, new Object[] { vb.getId(),request.getQuoteOrderDate(),request.getQuoteDeadline(),request.getQuoteStatusVehicle(),request.getQuotePaymentMethod(),request.getQuotePaymentStatus(),request.getQuoteAdvancePayment(),request.getQuoteRequireInvoice(), request.getQuoteId() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean removeQuoteById(Integer id) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_QUOTES_REMOVE_BY_ID, id);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}
	
	

}
