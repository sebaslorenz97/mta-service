package com.dulsystems.mta.service;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IQuoteDetailService {
	
	//SERVICES FOR QUOTE
	ResponseBean searchQuoteById(Integer id);
	ResponseBean executeSaveQuote(RequestBean request);
	ResponseBean executeUpdateQuoteById(RequestBean request);
	ResponseBean removeQuoteById(Integer id);
	
	//SERVICES FOR DETAILS OF A QUOTE
	ResponseBean searchQuoteDetailsById(Integer quoteId);
	ResponseBean executeSaveQuoteDetails(RequestBean request);
	ResponseBean executeUpdateQuoteDetailsById(RequestBean request);
	ResponseBean removeQuoteDetailById(Integer quoteId);
	
}
