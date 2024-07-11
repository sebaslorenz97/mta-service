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
import com.dulsystems.mta.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle")
@Validated
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value="getvehiclebyplate/{plate}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehicleByPlate(@PathVariable("plate") String plate)  {
		return new ResponseEntity<ResponseBean>(vehicleService.searchVehicleByPlate(plate),HttpStatus.OK);
    }
    
    @RequestMapping(value="getcustomervehiclesbycustomername/{customer}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchCustomerVehiclesByCustomerName(@PathVariable("customer") String customer)  {
		return new ResponseEntity<ResponseBean>(vehicleService.searchCustomerVehiclesByCustomerName(customer),HttpStatus.OK);
    }
    
    @RequestMapping(value="getvehiclesbystringplate/{string}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehiclesByStringName(@PathVariable("string") String string)  {
		return new ResponseEntity<ResponseBean>(vehicleService.searchVehiclesByStringName(string),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewvehicle", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveVehicle(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(vehicleService.executeSaveVehicle(request),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editvehiclebyplate", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateVehicleByPlate(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(vehicleService.executeUpdateVehicleByPlate(request),HttpStatus.OK);
    }
	
	@RequestMapping(value="removevehiclebyplate/{plate}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeVehicleByPlate(@PathVariable("plate") String plate) {
		return new ResponseEntity<ResponseBean>(vehicleService.removeVehicleByPlate(plate),HttpStatus.OK);
    }

}
