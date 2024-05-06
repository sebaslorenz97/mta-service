package com.dulsystems.mta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.service.QuoteService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/mi-taller-automotriz/quote")
@Validated
public class QuoteController {
	
	@Autowired
	private QuoteService quoteService;

	@RequestMapping(value="getquotebyid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchQuoteById(@PathVariable("quoteId") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String quoteId)  {
		return quoteService.searchQuoteById(Integer.parseInt(quoteId));
    }
	
	@RequestMapping(value="savenewquote", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveQuote(@Valid @RequestBody RequestBean rb) {
    	return quoteService.executeSaveQuote(rb);
    }
	
	@RequestMapping(value="editquotebyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateQuoteById(@Valid @RequestBody RequestBean rb) {
    	return quoteService.executeUpdateQuoteById(rb);
    }
	
	@RequestMapping(value="removequotebyid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeQuoteById(@PathVariable("quoteId") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String quoteId) {
    	return quoteService.removeQuoteById(Integer.parseInt(quoteId));
    }
	
}
