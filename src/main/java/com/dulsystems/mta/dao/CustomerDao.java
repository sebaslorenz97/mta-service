package com.dulsystems.mta.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	public CustomerBean searchCustomerByName(String name) {
		try {
			CustomerBean cb = jdbcTemplate.queryForObject(Queries.Q_CUSTOMERS_SEARCH_BY_NAME, new CustomerMapper(), name);
			return cb;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	@Override
	public List<String> searchCustomersByStringName(String string) {
		try {
			StringBuilder stringB = new StringBuilder();
			stringB.append("%");
			stringB.append(string);
			stringB.append("%");
			List<String> cl = jdbcTemplate.queryForList(Queries.Q_CUSTOMERS_SEARCH_CONTAINS, String.class, stringB.toString());
			return cl;
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
	public boolean executeUpdateCustomerByName(RequestBean request, StateBean sb, MunicipalityBean mb) {
		System.out.println("YA ESTA EN UPDATE CUSTOMER DAO");
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_CUSTOMERS_UPDATE_BY_NAME, new Object[] { sb.getStateId(), mb.getMunicipalityId(), request.getNewCustomerName(), request.getCustomerParticularEmpresa(), request.getCustomerReference(), request.getCustomerRfc(), request.getCustomerCp(), request.getCustomerEmail(), request.getCustomerPhoneNumber(), request.getCustomerName() });
        if (result > 0) {
            bin = true;
        }
		return bin;
	}
	
	@Override
	public boolean removeCustomerByName(String name) {
		boolean bin = false;
		int result = jdbcTemplate.update(Queries.Q_CUSTOMERS_REMOVE_BY_NAME, name);
		if (result > 0) {
            bin = true;
        }
		return bin;
	}

}
