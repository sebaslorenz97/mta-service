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
    public ResponseEntity<ResponseBean> searchStateByState(@PathVariable("state") String state)  {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.searchStateByState(state),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewstate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveState(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.executeSaveState(request),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editstatebystate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateStateByState(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.executeUpdateStateByState(request),HttpStatus.OK);
    }
	
	@RequestMapping(value="removestatebystate/{state}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeStateByState(@PathVariable("state") String state) {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.removeStateByState(state),HttpStatus.OK);
    }
	
	//CONTROLLERS FOR MUNICIPALITY
	@RequestMapping(value="getmunicipalitybymunicipality/{municipality}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchMunicipalitybyMunicipality(@PathVariable("municipality") String municipality)  {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.searchMunicipalityByMunicipality(municipality),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewmunicipalitybymunicipality", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveMunicipality(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.executeSaveMunicipality(request),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editmunicipalitybymunicipality", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateMunicipalitybyMunicipality(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.executeUpdateMunicipalityByMunicipality(request),HttpStatus.OK);
    }
	
	@RequestMapping(value="removemunicipalitybymunicipality/{municipality}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeMunicipalitybyMunicipality(@PathVariable("municipality") String municipality) {
		return new ResponseEntity<ResponseBean>(addressCatalogsService.removeMunicipalityByMunicipality(municipality),HttpStatus.OK);
    }
	
}
