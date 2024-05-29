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
import com.dulsystems.mta.service.AddressCatalogsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/address-catalogs")
@Validated
public class AddressCatalogsController {
	
	@Autowired
	private AddressCatalogsService addressCatalogsService; 
	
	//CONTROLLERS FOR STATE
	@RequestMapping(value="getstatebystate/{state}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchStateByState(@PathVariable("state") /*@Pattern(regexp = "^\\d{2}$", message="El formato del estado del empleado es invalido")*/ String state)  {
		return addressCatalogsService.searchStateByState(state);
    }
	
	@RequestMapping(value="savenewstate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveState(@Valid @RequestBody RequestBean request) {
    	return addressCatalogsService.executeSaveState(request);
    }
	
	@RequestMapping(value="editstatebystate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateStateByState(@Valid @RequestBody RequestBean request) {
    	return addressCatalogsService.executeUpdateStateByState(request);
    }
	
	@RequestMapping(value="removestatebystate/{state}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeStateByState(@PathVariable("state") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String state) {
    	return addressCatalogsService.removeStateByState(state);
    }
	
	//CONTROLLERS FOR MUNICIPALITY
	@RequestMapping(value="getmunicipalitybymunicipality/{municipality}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchMunicipalitybyMunicipality(@PathVariable("municipality") /*@Pattern(regexp = "^\\d{2}$", message="El formato del estado del empleado es invalido")*/ String municipality)  {
		return addressCatalogsService.searchMunicipalityByMunicipality(municipality);
    }
	
	@RequestMapping(value="savenewmunicipalitybymunicipality", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveMunicipality(@Valid @RequestBody RequestBean request) {
    	return addressCatalogsService.executeSaveMunicipality(request);
    }
	
	@RequestMapping(value="editmunicipalitybymunicipality", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateMunicipalitybyMunicipality(@Valid @RequestBody RequestBean request) {
    	return addressCatalogsService.executeUpdateMunicipalityByMunicipality(request);
    }
	
	@RequestMapping(value="removemunicipalitybymunicipality/{municipality}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeMunicipalitybyMunicipality(@PathVariable("municipality") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String municipality) {
    	return addressCatalogsService.removeMunicipalityByMunicipality(municipality);
    }
	
}
