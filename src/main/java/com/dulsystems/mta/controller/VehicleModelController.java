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
import com.dulsystems.mta.service.VehicleModelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle-model")
@Validated
public class VehicleModelController {

	@Autowired
	VehicleModelService vehicleModelService;
	
	@RequestMapping(value="getvehiclemodelbymodel/{model}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleModelByModel(@PathVariable("model") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String model)  {
		return vehicleModelService.searchVehicleModelByModel(model);
    }
	
	@RequestMapping(value="savenewvehiclemodel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicleModel(@Valid @RequestBody RequestBean request) {
    	return vehicleModelService.executeSaveVehicleModel(request);
    }
	
	@RequestMapping(value="editvehiclemodel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleModelByModel(@Valid @RequestBody RequestBean request) {
    	return vehicleModelService.executeUpdateVehicleModelByModel(request);
    }
	
	@RequestMapping(value="removevehiclemodelbymodel/{model}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleModelByModel(@PathVariable("model") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String model) {
    	return vehicleModelService.removeVehicleModelByModel(model);
    }
	
}
