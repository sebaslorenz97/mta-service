package com.dulsystems.mta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.mapper.CustomerMapper;
import com.dulsystems.mta.dao.mapper.MunicipalityMapper;
import com.dulsystems.mta.dao.mapper.StateMapper;
import com.dulsystems.mta.util.Queries;

@Repository
public class CustomerDao implements ICustomerDao{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public CustomerBean searchCustomerById(Integer id) {
		try {
			CustomerBean cb = jdbcTemplate.queryForObject(Queries.Q_CUSTOMERS_SEARCH_BY_ID, new CustomerMapper(), id);
			return cb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public boolean executeSaveCustomer(RequestBean request, StateBean sb, MunicipalityBean mb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_CUSTOMERS_SAVE, new Object[] { sb.getStateId(), mb.getMunicipalityId(), request.getCustomerName(), request.getCustomerParticularEmpresa(), request.getCustomerReference(), request.getCustomerRfc(), request.getCustomerCp(), request.getCustomerEmail(), request.getCustomerPhoneNumber() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}

	@Override
	public boolean executeUpdateCustomerById(RequestBean request, StateBean sb, MunicipalityBean mb) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_CUSTOMERS_UPDATE_BY_ID, new Object[] { sb.getStateId(), mb.getMunicipalityId(), request.getCustomerName(), request.getCustomerParticularEmpresa(), request.getCustomerReference(), request.getCustomerRfc(), request.getCustomerCp(), request.getCustomerEmail(), request.getCustomerPhoneNumber(), request.getCustomerId() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}
	
	@Override
	public boolean removeCustomerById(Integer id) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_CUSTOMERS_REMOVE_BY_ID, id);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
