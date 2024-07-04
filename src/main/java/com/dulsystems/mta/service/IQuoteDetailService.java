package com.dulsystems.mta.service;

import java.util.List;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;

public interface IQuoteDetailService {
	
	//SERVICES FOR QUOTE
	ResponseBean searchQuoteById(Integer id);
	ResponseBean executeSaveQuote(RequestBean request);
	ResponseBean searchVehicleQuotesByVehiclePlate(String vehiclePlate);
	ResponseBean executeUpdateQuoteById(RequestBean request);
	ResponseBean removeQuoteById(Integer id);
	
	//SERVICES FOR DETAILS OF A QUOTE
	ResponseBean searchQuoteDetailsByQuoteId(Integer quoteId, ResponseBean response);
	ResponseBean executeSaveEditAndDeleteQuoteDetailsByDetailId(RequestBean request);
	ResponseBean executeUpdateQuoteDetailsByDetailId(RequestBean request, List<QuoteDetailBean> lqdbForUpdate, ResponseBean response);
	ResponseBean removeQuoteDetailsByDetailId(RequestBean request, int[] lqdbForDelete, ResponseBean response);
	ResponseBean removeQuoteDetailsByQuoteId(Integer quoteId, ResponseBean response);
	
}
