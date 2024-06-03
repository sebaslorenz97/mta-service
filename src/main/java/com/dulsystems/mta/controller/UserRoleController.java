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
	public ResponseBean searchUserByUser(@PathVariable("user") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String user)  {
		return userRoleService.searchUserByUser(user);
	}
	
	@RequestMapping(value="savenewuser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseBean> executeSaveUser(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(userRoleService.executeSaveUser(rb),HttpStatus.OK);
	}
		
	@RequestMapping(value="edituserbyuserforadmin", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseBean executeUpdateUserByUserForAdmin(@Valid @RequestBody RequestBean rb) {
	  	return userRoleService.executeUpdateUserByUserForAdmin(rb);
	}
		
	@RequestMapping(value="removeuserbyuser/{user}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseBean removeUserByUser(@PathVariable("user") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String user) {
	  	return userRoleService.removeUserByUser(user);
	}
		
	//CONTROLLERS FOR USER ROLES
	@RequestMapping(value="getalluserroles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseBean getAllUserRole(@Valid @RequestBody RequestBean rb)  {
		return userRoleService.searchAllUserRoles(rb);
	}
		
	@RequestMapping(value="savenewuserrole", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseBean executeSaveUserRole(@Valid @RequestBody RequestBean rb) {
	  	return userRoleService.executeSaveUserRole(rb);
	}
		
	@RequestMapping(value="edituserrolebyroleanduser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseBean executeUpdateUserRoleByRoleAndUser(@Valid @RequestBody RequestBean rb) {
	  	return userRoleService.executeUpdateUserRoleByRoleAndUser(rb);
	}
		
	@RequestMapping(value="removeuserrolebyroleanduser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public ResponseBean removeUserRoleByRoleAndUser(@Valid @RequestBody RequestBean rb) {
	   	return userRoleService.removeUserRoleByRoleAndUser(rb);
	}

}
