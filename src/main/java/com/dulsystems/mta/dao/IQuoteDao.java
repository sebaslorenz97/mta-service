package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleBean;
public interface IQuoteDao {

	QuoteBean searchQuoteById(Integer id);
	
	boolean executeSaveQuote(RequestBean request, VehicleBean vb);
	
	boolean executeUpdateQuoteById(RequestBean request, VehicleBean vb);
	
	boolean removeQuoteById(Integer id);
	
}
