package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IStateService {

	ResponseBean searchStateByState(String state);
	
	ResponseBean executeSaveState(RequestBean request);
	
	ResponseBean executeUpdateStateByState(RequestBean request);
	
	ResponseBean removeStateByState(String state);
	
}
