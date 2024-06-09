package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleBean;

public interface IQuoteDetailDao {
	
	//DAO FOR QUOTE
	QuoteBean searchQuoteById(Integer id);
	QuoteBean searchLastQuoteCreated(RequestBean request, Integer vehicleId);
	boolean executeSaveQuote(RequestBean request, VehicleBean vb);
	boolean executeUpdateQuoteById(RequestBean request, VehicleBean vb);
	boolean removeQuoteById(Integer id);
	
	//DAO FOR DETAILS OF A QUOTE
	List<QuoteDetailBean> searchQuoteDetailsByQuoteId(Integer quoteId);
	int[] executeSaveQuoteDetails(RequestBean request, List<QuoteDetailBean> lqdb);
	int[] executeUpdateQuoteDetailsByQuoteId(RequestBean request, List<QuoteDetailBean> lqdb);
	boolean removeQuoteDetailsByQuoteId(Integer quoteId);
	
}
