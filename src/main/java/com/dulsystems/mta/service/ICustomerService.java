package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface ICustomerService {
	
	ResponseBean searchCustomerByName(String name);
	
	ResponseBean executeSaveCustomer(RequestBean request);
	
	ResponseBean executeUpdateCustomerByName(RequestBean request);
	
	ResponseBean removeCustomerByName(String name);
	
}