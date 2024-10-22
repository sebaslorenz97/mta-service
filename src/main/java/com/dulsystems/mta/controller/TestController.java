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
import com.dulsystems.mta.service.UserRoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/test-controller")
@Validated
public class TestController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(value="gettestdata", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> getTestData()  {
		ResponseBean response = userRoleService.searchUserByUserOrMecId("sebaslorenz97", null);
		response.setCode("OK-GET");
		response.setMessage("Test Controller Response");
		return new ResponseEntity<ResponseBean>(response,HttpStatus.OK);
    }
	
	@RequestMapping(value="posttestdata", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> postTestData(@Valid @RequestBody RequestBean rb) {
		ResponseBean response = new ResponseBean();
		response.setCode("OK-POST");
		response.setMessage("Test Controller Response");
		return new ResponseEntity<ResponseBean>(response,HttpStatus.CREATED);
    }

}
