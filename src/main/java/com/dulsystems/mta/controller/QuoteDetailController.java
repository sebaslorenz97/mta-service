package com.dulsystems.mta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/mi-taller-automotriz/quote-and-details")
@Validated
public class QuoteDetailController {

	@Autowired
	private QuoteDetailService quoteDetailService;
	
	//CONTROLLERS FOR QUOTE
	@RequestMapping(value="getquotebyid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchQuoteById(@PathVariable("quoteId") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String quoteId)  {
		return new ResponseEntity<ResponseBean>(quoteDetailService.searchQuoteById(Integer.parseInt(quoteId)),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewquote", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveQuote(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.executeSaveQuote(rb),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editquotebyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateQuoteById(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.executeUpdateQuoteById(rb),HttpStatus.OK);
    }
	
	@RequestMapping(value="removequotebyid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeQuoteById(@PathVariable("quoteId") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String quoteId) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.removeQuoteById(Integer.parseInt(quoteId)),HttpStatus.OK);
    }
	
	//CONTROLLERS FOR DETAILS OF A QUOTE
	@RequestMapping(value="getallquotedetailsbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchQuoteDetailsById(@PathVariable("id") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String id)  {
		return new ResponseEntity<ResponseBean>(quoteDetailService.searchQuoteDetailsById(Integer.parseInt(id)),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewquotedetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveQuoteDetails(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.executeSaveQuoteDetails(rb),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editquotedetailbyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateQuoteDetailById(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.executeUpdateQuoteDetailsById(rb),HttpStatus.OK);
    }
	
	@RequestMapping(value="removequotedetailbyid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeQuoteDetailById(@PathVariable("quoteId") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String quoteId) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.removeQuoteDetailById(Integer.parseInt(quoteId)),HttpStatus.OK);
    }
}
