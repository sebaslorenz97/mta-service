package com.dulsystems.mta.service;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IQuoteDetailService {

	ResponseBean searchQuoteDetailsById(Integer quoteId);
	
	ResponseBean executeSaveQuoteDetails(RequestBean request);
	
	ResponseBean executeUpdateQuoteDetailsById(RequestBean request);
	
	ResponseBean removeQuoteDetailById(Integer quoteId);
	
}
