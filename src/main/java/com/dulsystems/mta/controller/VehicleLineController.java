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
import com.dulsystems.mta.service.VehicleLineService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle-line")
@Validated
public class VehicleLineController {
	
	@Autowired
	VehicleLineService vehicleLineService;
	
	@RequestMapping(value="getvehiclelinebyline/{line}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleLineByLine(@PathVariable("line") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String line)  {
		return vehicleLineService.searchVehicleLineByLine(line);
    }
	
	@RequestMapping(value="savenewvehicleline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicleLine(@Valid @RequestBody RequestBean request) {
    	return vehicleLineService.executeSaveVehicleLine(request);
    }
	
	@RequestMapping(value="editvehicleline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleLineByLine(@Valid @RequestBody RequestBean request) {
    	return vehicleLineService.executeUpdateVehicleLineByLine(request);
    }
	
	@RequestMapping(value="removevehiclelinebyline/{line}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleLineByLine(@PathVariable("line") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String line) {
    	return vehicleLineService.removeVehicleLineByLine(line);
    }

}
