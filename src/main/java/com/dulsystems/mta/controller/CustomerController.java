package com.dulsystems.mta.controller;

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

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/mi-taller-automotriz/customer")
@Validated
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="getcustomerbyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchCustomerByName(@PathVariable("name") String name)  {
		return new ResponseEntity<ResponseBean>(customerService.searchCustomerByName(name),HttpStatus.OK);
    }
	
	@RequestMapping(value="getcustomersbystringname/{string}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchCustomersByStringName(@PathVariable("string") String string)  {
		return new ResponseEntity<ResponseBean>(customerService.searchCustomersByStringName(string),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewcustomer", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveCustomer(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(customerService.executeSaveCustomer(rb),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editcustomerbyname", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateCustomerByName(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(customerService.executeUpdateCustomerByName(rb),HttpStatus.OK);
    }
	
	@RequestMapping(value="removecustomerbyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeCustomerByName(@PathVariable("name") String name) {
		return new ResponseEntity<ResponseBean>(customerService.removeCustomerByName(name),HttpStatus.OK);
    }

}
