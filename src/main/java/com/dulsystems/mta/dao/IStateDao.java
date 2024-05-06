package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.StateBean;

public interface IStateDao {
	
	StateBean searchStateById(Integer id);
	
	StateBean searchStateByState(String state);
	
	boolean executeSaveState(RequestBean request);
	
	boolean executeUpdateStateByState(RequestBean request);
	
	boolean removeStateByState(String state);

}
