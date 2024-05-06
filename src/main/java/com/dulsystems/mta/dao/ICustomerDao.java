package com.dulsystems.mta.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;

public interface ICustomerDao {
	
	CustomerBean searchCustomerById(Integer id);
	
	boolean executeSaveCustomer(RequestBean request, StateBean sb, MunicipalityBean mb);
	
	boolean executeUpdateCustomerById(RequestBean request, StateBean sb, MunicipalityBean mb);
	
	boolean removeCustomerById(Integer id);
	
}