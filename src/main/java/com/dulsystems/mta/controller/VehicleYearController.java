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
import com.dulsystems.mta.service.VehicleYearService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle-year")
@Validated
public class VehicleYearController {
	
	@Autowired
	VehicleYearService vehicleYearService;
	
	@RequestMapping(value="getvehicleyearbyyear/{year}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseBean searchVehicleYearByYear(@PathVariable("year") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String year)  {
		return vehicleYearService.searchVehicleYearByYear(Integer.parseInt(year));
    }
	
	@RequestMapping(value="savenewvehicleyear", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseBean executeSaveVehicleYear(@Valid @RequestBody RequestBean rb) {
    	return vehicleYearService.executeSaveVehicleYear(rb);
    }
	
	@RequestMapping(value="editvehicleyear", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseBean executeUpdateVehicleYearByYear(@Valid @RequestBody RequestBean rb) {
    	return vehicleYearService.executeUpdateVehicleYearByYear(rb);
    }
	
	@RequestMapping(value="removevehicleyearbyyear/{year}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseBean removeVehicleYearByYear(@PathVariable("year") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String year) {
    	return vehicleYearService.removeVehicleYearByYear(Integer.parseInt(year));
    }
	
}
