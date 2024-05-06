package com.dulsystems.mta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.service.QuoteDetailService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/mi-taller-automotriz/quote-detail")
@Validated
public class QuoteDetailController {

	@Autowired
	private QuoteDetailService quoteDetailService;
	
	@RequestMapping(value="getallquotedetailsbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchQuoteDetailsById(@PathVariable("id") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String id)  {
		return quoteDetailService.searchQuoteDetailsById(Integer.parseInt(id));
    }
	
	@RequestMapping(value="savenewquotedetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveQuoteDetails(@Valid @RequestBody RequestBean rb) {
    	return quoteDetailService.executeSaveQuoteDetails(rb);
    }
	
	@RequestMapping(value="editquotedetailbyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateQuoteDetailById(@Valid @RequestBody RequestBean rb) {
    	return quoteDetailService.executeUpdateQuoteDetailsById(rb);
    }
	
	@RequestMapping(value="removequotedetailbyid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeQuoteDetailById(@PathVariable("quoteId") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String quoteId) {
    	return quoteDetailService.removeQuoteDetailById(Integer.parseInt(quoteId));
    }
}
