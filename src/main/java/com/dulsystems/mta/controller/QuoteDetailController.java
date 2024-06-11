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
    public ResponseEntity<ResponseBean> searchQuoteById(@PathVariable("quoteId") String quoteId)  {
		return new ResponseEntity<ResponseBean>(quoteDetailService.searchQuoteById(Integer.parseInt(quoteId)),HttpStatus.OK);
    }
	
    @RequestMapping(value="searchvehiclequotesbyvehicleplate/{plate}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehicleQuotesByVehiclePlate(@PathVariable("plate") String plate)  {
		return new ResponseEntity<ResponseBean>(quoteDetailService.searchVehicleQuotesByVehiclePlate(plate),HttpStatus.OK);
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
    public ResponseEntity<ResponseBean> removeQuoteById(@PathVariable("quoteId") String quoteId) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.removeQuoteById(Integer.parseInt(quoteId)),HttpStatus.OK);
    }
	
	//CONTROLLERS FOR DETAILS OF A QUOTE
	@RequestMapping(value="getallquotedetailsbyquoteid/{quoteid}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchQuoteDetailsByQuoteId(@PathVariable("quoteid") String quoteid)  {
		return new ResponseEntity<ResponseBean>(quoteDetailService.searchQuoteDetailsByQuoteId(Integer.parseInt(quoteid)),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewquotedetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveQuoteDetails(@Valid @RequestBody RequestBean rb) {
		System.out.println("COTIZACION ID ---------> "+ rb.getLqdb().get(0).getQuoteDetailIdFk());
		return new ResponseEntity<ResponseBean>(quoteDetailService.executeSaveQuoteDetails(rb),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editquotedetailsbyquoteid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateQuoteDetailsByQuoteId(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.executeUpdateQuoteDetailsByQuoteId(rb),HttpStatus.OK);
    }
	
	@RequestMapping(value="removequotedetailsbyquoteid/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeQuoteDetailsByQuoteId(@PathVariable("quoteId") String quoteId) {
		return new ResponseEntity<ResponseBean>(quoteDetailService.removeQuoteDetailsByQuoteId(Integer.parseInt(quoteId)),HttpStatus.OK);
    }
}
