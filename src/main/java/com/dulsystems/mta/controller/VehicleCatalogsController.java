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
import com.dulsystems.mta.service.VehicleCatalogsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle-catalogs")
@Validated
public class VehicleCatalogsController {
	
	@Autowired
	VehicleCatalogsService vehicleCatalogsService;
	
	//CONTROLLERS FOR VEHICLE LINE
	@RequestMapping(value="getvehiclelinebyline/{line}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleLineByLine(@PathVariable("line") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String line)  {
		return vehicleCatalogsService.searchVehicleLineByLine(line);
    }
	
	@RequestMapping(value="savenewvehicleline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicleLine(@Valid @RequestBody RequestBean request) {
    	return vehicleCatalogsService.executeSaveVehicleLine(request);
    }
	
	@RequestMapping(value="editvehicleline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleLineByLine(@Valid @RequestBody RequestBean request) {
    	return vehicleCatalogsService.executeUpdateVehicleLineByLine(request);
    }
	
	@RequestMapping(value="removevehiclelinebyline/{line}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleLineByLine(@PathVariable("line") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String line) {
    	return vehicleCatalogsService.removeVehicleLineByLine(line);
    }
	
	//CONTROLLERS FOR VEHICLE MODEL
	@RequestMapping(value="getvehiclemodelbymodel/{model}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleModelByModel(@PathVariable("model") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String model)  {
		return vehicleCatalogsService.searchVehicleModelByModel(model);
    }
	
	@RequestMapping(value="savenewvehiclemodel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicleModel(@Valid @RequestBody RequestBean request) {
    	return vehicleCatalogsService.executeSaveVehicleModel(request);
    }
	
	@RequestMapping(value="editvehiclemodel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleModelByModel(@Valid @RequestBody RequestBean request) {
    	return vehicleCatalogsService.executeUpdateVehicleModelByModel(request);
    }
	
	@RequestMapping(value="removevehiclemodelbymodel/{model}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleModelByModel(@PathVariable("model") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String model) {
    	return vehicleCatalogsService.removeVehicleModelByModel(model);
    }
	
	//CONTROLLERS FOR VEHICLE YEAR
	@RequestMapping(value="getvehicleyearbyyear/{year}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleYearByYear(@PathVariable("year") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String year)  {
		return vehicleCatalogsService.searchVehicleYearByYear(Integer.parseInt(year));
    }
	
	@RequestMapping(value="savenewvehicleyear", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicleYear(@Valid @RequestBody RequestBean rb) {
    	return vehicleCatalogsService.executeSaveVehicleYear(rb);
    }
	
	@RequestMapping(value="editvehicleyear", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleYearByYear(@Valid @RequestBody RequestBean rb) {
    	return vehicleCatalogsService.executeUpdateVehicleYearByYear(rb);
    }
	
	@RequestMapping(value="removevehicleyearbyyear/{year}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleYearByYear(@PathVariable("year") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String year) {
    	return vehicleCatalogsService.removeVehicleYearByYear(Integer.parseInt(year));
    }
	
}
