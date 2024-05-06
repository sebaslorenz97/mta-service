package com.dulsystems.mta.service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IQuoteService {
	
	ResponseBean searchQuoteById(Integer id);
	
	ResponseBean executeSaveQuote(RequestBean request);
	
	ResponseBean executeUpdateQuoteById(RequestBean request);
	
	ResponseBean removeQuoteById(Integer id);

}
