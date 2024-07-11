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
import com.dulsystems.mta.service.VehicleCatalogsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mi-taller-automotriz/vehicle-catalogs")
@Validated
public class VehicleCatalogsController {
	
	@Autowired
	VehicleCatalogsService vehicleCatalogsService;
	
	//CONTROLLER FOR SEARCH VEHICLE LINES MODELS AND YEARS
	@RequestMapping(value="getvehiclelinesmodelsandyears", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehicleLinesModelsAndYears()  {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.searchVehicleLinesModelsAndYears(null),HttpStatus.OK);
    }
	
	//CONTROLLERS FOR VEHICLE LINE
	@RequestMapping(value="getvehiclelinebyline/{line}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehicleLineByLine(@PathVariable("line") String line)  {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.searchVehicleLineByLine(line),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewvehicleline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveVehicleLine(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.executeSaveVehicleLine(request),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editvehicleline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateVehicleLineByLine(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.executeUpdateVehicleLineByLine(request),HttpStatus.OK);
    }
	
	@RequestMapping(value="removevehiclelinebyline/{line}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeVehicleLineByLine(@PathVariable("line") /*@Pattern(regexp = "^\\d{2}$", message="El formato del id del empleado es invalido")*/ String line) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.removeVehicleLineByLine(line),HttpStatus.OK);
    }
	
	//CONTROLLERS FOR VEHICLE MODEL
	@RequestMapping(value="getvehiclemodelbymodel/{model}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehicleModelByModel(@PathVariable("model") String model)  {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.searchVehicleModelByModel(model),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewvehiclemodel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveVehicleModel(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.executeSaveVehicleModel(request),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editvehiclemodel", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateVehicleModelByModel(@Valid @RequestBody RequestBean request) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.executeUpdateVehicleModelByModel(request),HttpStatus.OK);
    }
	
	@RequestMapping(value="removevehiclemodelbymodel/{model}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeVehicleModelByModel(@PathVariable("model") String model) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.removeVehicleModelByModel(model),HttpStatus.OK);
    }
	
	//CONTROLLERS FOR VEHICLE YEAR
	@RequestMapping(value="getvehicleyearbyyear/{year}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> searchVehicleYearByYear(@PathVariable("year") String year)  {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.searchVehicleYearByYear(Integer.parseInt(year)),HttpStatus.OK);
    }
	
	@RequestMapping(value="savenewvehicleyear", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<ResponseBean> executeSaveVehicleYear(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.executeSaveVehicleYear(rb),HttpStatus.CREATED);
    }
	
	@RequestMapping(value="editvehicleyear", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<ResponseBean> executeUpdateVehicleYearByYear(@Valid @RequestBody RequestBean rb) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.executeUpdateVehicleYearByYear(rb),HttpStatus.OK);
    }
	
	@RequestMapping(value="removevehicleyearbyyear/{year}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public ResponseEntity<ResponseBean> removeVehicleYearByYear(@PathVariable("year") String year) {
		return new ResponseEntity<ResponseBean>(vehicleCatalogsService.removeVehicleYearByYear(Integer.parseInt(year)),HttpStatus.OK);
    }
	
}
