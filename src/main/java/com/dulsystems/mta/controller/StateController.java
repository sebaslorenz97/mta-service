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
import com.dulsystems.mta.service.StateService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/mi-taller-automotriz/state")
@Validated
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@RequestMapping(value="getstatebystate/{state}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchStateByState(@PathVariable("state") /*@Pattern(regexp = "^\\d{2}$", message="El formato del estado del empleado es invalido")*/ String state)  {
		return stateService.searchStateByState(state);
    }
	
	@RequestMapping(value="savenewstate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveState(@Valid @RequestBody RequestBean request) {
    	return stateService.executeSaveState(request);
    }
	
	@RequestMapping(value="editstatebystate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateStateByState(@Valid @RequestBody RequestBean request) {
    	return stateService.executeUpdateStateByState(request);
    }
	
	@RequestMapping(value="removestatebystate/{state}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeStateByState(@PathVariable("state") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String state) {
    	return stateService.removeStateByState(state);
    }

}
