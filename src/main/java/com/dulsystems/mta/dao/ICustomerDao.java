package com.dulsystems.mta.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;

public interface ICustomerDao {
	
	CustomerBean searchCustomerByName(String name);
	
	List<String> searchCustomersByStringName(String string);
	
	boolean executeSaveCustomer(RequestBean request, StateBean sb, MunicipalityBean mb);
	
	boolean executeUpdateCustomerByName(RequestBean request, StateBean sb, MunicipalityBean mb);
	
	boolean removeCustomerByName(String name);
	
}