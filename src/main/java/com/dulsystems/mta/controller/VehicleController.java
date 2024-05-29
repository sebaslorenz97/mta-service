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
import com.dulsystems.mta.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle")
@Validated
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value="getvehiclebyplate/{plate}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleByPlate(@PathVariable("plate") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String plate)  {
		return vehicleService.searchVehicleByPlate(plate);
    }
	
	@RequestMapping(value="savenewvehicle", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicle(@Valid @RequestBody RequestBean request) {
    	return vehicleService.executeSaveVehicle(request);
    }
	
	@RequestMapping(value="editvehiclebyplate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleByPlate(@Valid @RequestBody RequestBean request) {
    	return vehicleService.executeUpdateVehicleByPlate(request);
    }
	
	@RequestMapping(value="removevehiclebyplate/{plate}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleByPlate(@PathVariable("plate") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String plate) {
    	return vehicleService.removeVehicleByPlate(plate);
    }

}
