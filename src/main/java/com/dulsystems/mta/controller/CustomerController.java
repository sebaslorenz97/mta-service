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
import com.dulsystems.mta.service.CustomerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/mi-taller-automotriz/customer")
@Validated
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="getcustomerbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchCustomerById(@PathVariable("id") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String id)  {
		return customerService.searchCustomerById(Integer.parseInt(id));
    }
	
	@RequestMapping(value="savenewcustomer", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveCustomer(@Valid @RequestBody RequestBean rb) {
    	return customerService.executeSaveCustomer(rb);
    }
	
	@RequestMapping(value="editcustomer", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateCustomerById(@Valid @RequestBody RequestBean rb) {
    	return customerService.executeUpdateCustomerById(rb);
    }
	
	@RequestMapping(value="removecustomerbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeCustomerById(@PathVariable("id") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String id) {
    	return customerService.removeCustomerById(Integer.parseInt(id));
    }

}
