package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface ICustomerService {
	
	ResponseBean searchCustomerById(Integer id);
	
	ResponseBean executeSaveCustomer(RequestBean request);
	
	ResponseBean executeUpdateCustomerById(RequestBean request);
	
	ResponseBean removeCustomerById(Integer id);
	
}