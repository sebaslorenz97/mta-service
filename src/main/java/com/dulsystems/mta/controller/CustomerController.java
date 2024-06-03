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
	
	@RequestMapping(value="getcustomerbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchCustomerById(@PathVariable("id") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String id)  {
		return new ResponseEntity<ResponseBean>(customerService.searchCustomerById(Integer.parseInt(id)),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewcustomer", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveCustomer(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(customerService.executeSaveCustomer(rb),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editcustomer", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateCustomerById(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(customerService.executeUpdateCustomerById(rb),HttpStatus.OK);
    }
	
	@RequestMapping(value="removecustomerbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeCustomerById(@PathVariable("id") @Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido") String id) {
		return new ResponseEntity<ResponseBean>(customerService.removeCustomerById(Integer.parseInt(id)),HttpStatus.OK);
    }

}
