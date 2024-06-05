package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.dao.mapper.QuoteDetailMapper;
import com.dulsystems.mta.dao.mapper.QuoteMapper;
import com.dulsystems.mta.util.Queries;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class QuoteDetailDao implements IQuoteDetailDao{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	//DAO FOR QUOTE
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
	
	//DAO FOR DETAILS OF A QUOTE
	@Override
	public List<QuoteDetailBean> searchQuoteDetailsByQuoteId(Integer quoteId) {
		try {
			List<QuoteDetailBean> lqdb = jdbcTemplate.query(Queries.Q_QUOTE_DETAILS_SEARCH_BY_ID,  new QuoteDetailMapper(), quoteId);
			System.out.println(lqdb);
			return lqdb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public int[] executeSaveQuoteDetails(RequestBean request, List<QuoteDetailBean> lqdb) {
		return jdbcTemplate.batchUpdate(
				Queries.Q_QUOTE_DETAILS_SAVE,
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						QuoteDetailBean qdb = lqdb.get(i);
						ps.setInt(1, qdb.getQuoteDetailIdFk());
						ps.setInt(2, qdb.getQuoteDetailMecId());
						ps.setString(3, qdb.getQuoteDetailLabour());
						ps.setLong(4, qdb.getQuoteDetailAmount().longValue());
					}
					public int getBatchSize() {
						return lqdb.size();
					}
				});
	}
	/*public boolean executeSaveQuoteDetail(RequestBean request, QuoteBean qb, List<QuoteDetailBean> lqdb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_QUOTE_DETAILS_SAVE, new Object[] { qb.getQuoteId(),request.getQuoteDetailMecId(),request.getQuoteDetailLabour(),request.getQuoteDetailAmount() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}*/

	@Override
	public int[] executeUpdateQuoteDetailsByQuoteId(RequestBean request, List<QuoteDetailBean> lqdb) {
		return jdbcTemplate.batchUpdate(
				Queries.Q_QUOTE_DETAILS_UPDATE_BY_ID,
				new BatchPreparedStatementSetter() {
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						QuoteDetailBean qdb = lqdb.get(i);
						ps.setInt(1, qdb.getQuoteDetailIdFk());
						ps.setInt(2, qdb.getQuoteDetailMecId());
						ps.setString(3, qdb.getQuoteDetailLabour());
						ps.setLong(4, qdb.getQuoteDetailAmount().longValue());
						ps.setInt(5, qdb.getQuoteDetailId());
					}
					public int getBatchSize() {
						return lqdb.size();
					}
				});
	}
	/*public boolean executeUpdateQuoteDetailById(RequestBean request, QuoteBean qb, List<QuoteDetailBean> lqdb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_QUOTES_UPDATE_BY_ID, new Object[] { qb.getQuoteId(),request.getQuoteDetailMecId(),request.getQuoteDetailLabour(),request.getQuoteDetailAmount(),request.getQuoteDetailIdl() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}*/

	@Override
	public boolean removeQuoteDetailsByQuoteId(Integer quoteId) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_QUOTE_DETAILS_REMOVE_BY_ID, quoteId);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
