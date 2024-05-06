package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;

public interface IQuoteDetailDao {

	List<QuoteDetailBean> searchQuoteDetailById(Integer quoteId);
	
	int[] executeSaveQuoteDetail(RequestBean request, /*QuoteBean qb,*/ List<QuoteDetailBean> lqdb);
	
	int[] executeUpdateQuoteDetailById(RequestBean request, /*QuoteBean qb,*/ List<QuoteDetailBean> lqdb);
	
	boolean removeQuoteDetailById(Integer quoteId);
	
}
