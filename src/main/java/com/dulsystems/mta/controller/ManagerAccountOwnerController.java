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
@RequestMapping("/mi-taller-automotriz/manager-account-owner")
@Validated
public class ManagerAccountOwnerController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(value="getuserforaccountowner", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> searchUserForAccountOwner()  {
		ResponseBean response = null;
		response = userRoleService.searchUserByUserOrMecId("search-by-username", null);
		return new ResponseEntity<ResponseBean>(response,HttpStatus.OK);
	}

	@RequestMapping(value="changepasswordforaccountowner", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<ResponseBean> executeUpdatePasswordForAccountOwner(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeUpdatePasswordForAccountOwner(rb),HttpStatus.OK);
	}
	
	@RequestMapping(value="changeemailforaccountowner", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<ResponseBean> executeUpdateEmailForAccountOwner(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeUpdateEmailForAccountOwner(rb),HttpStatus.OK);
	}
	
}
