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
@RequestMapping("/mi-taller-automotriz/user-and-roles")
@Validated
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
		
	//CONTROLLERS FOR USER DASHBOARD HANDLE
	@RequestMapping(value="getuserbyuser/{user}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> searchUserByUser(@PathVariable("user") String user)  {
		return new ResponseEntity<ResponseBean>(userRoleService.searchUserByUser(user),HttpStatus.OK);
	}
	
	@RequestMapping(value="savenewuser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> executeSaveUser(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeSaveUser(rb),HttpStatus.CREATED);
	}
		
	@RequestMapping(value="edituserbyuserforadmin", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<ResponseBean> executeUpdateUserByUserForAdmin(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeUpdateUserByUserForAdmin(rb),HttpStatus.OK);
	}
	
	@RequestMapping(value="removeuserbyuser/{user}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<ResponseBean> removeUserByUser(@PathVariable("user") String user) {
		return new ResponseEntity<ResponseBean>(userRoleService.removeUserByUser(user),HttpStatus.OK);
	}
		
	//CONTROLLERS FOR USER ROLES
	@RequestMapping(value="getalluserroles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<ResponseBean> getAllUserRole(@Valid @RequestBody RequestBean rb)  {
		return new ResponseEntity<ResponseBean>(userRoleService.searchAllUserRoles(rb),HttpStatus.OK);
	}
		
	@RequestMapping(value="savenewuserrole", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> executeSaveUserRole(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeSaveUserRole(rb),HttpStatus.CREATED);
	}
		
	@RequestMapping(value="edituserrolebyroleanduser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<ResponseBean> executeUpdateUserRoleByRoleAndUser(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeUpdateUserRoleByRoleAndUser(rb),HttpStatus.OK);
	}
		
	@RequestMapping(value="removeuserrolebyroleanduser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseEntity<ResponseBean> removeUserRoleByRoleAndUser(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.removeUserRoleByRoleAndUser(rb),HttpStatus.OK);
	}

}
