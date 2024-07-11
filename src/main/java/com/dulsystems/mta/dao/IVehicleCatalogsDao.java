package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;

public interface IVehicleCatalogsDao {
	
	List<String> searchVehicleLines();
	List<String> searchVehicleModels();
	List<String> searchVehicleYears();
	
	//DAO FOR VEHICLE LINE
	VehicleLineBean searchVehicleLineByLine(String vehicleLine);
	VehicleLineBean searchVehicleLineById(Integer vehicleId);
	boolean executeSaveVehicleLine(RequestBean request);
	boolean executeUpdateVehicleLineByLine(RequestBean request);
	boolean removeVehicleLineByLine(String vehicleLine);
	
	//DAO FOR VEHICLE MODEL
	VehicleModelBean searchVehicleModelByModel(String vehicleModel);
	boolean executeSaveVehicleModel(RequestBean request, VehicleLineBean vlb);
	boolean executeUpdateVehicleModelByModel(RequestBean request, VehicleLineBean vlb);
	boolean removeVehicleModelByModel(String vehicleModel);
	
	//DAO FOR VEHICLE YEAR
	VehicleYearBean searchVehicleYearByYear(Integer vehicleYear);
	boolean executeSaveVehicleYear(RequestBean request);
	boolean executeUpdateVehicleYearByYear(RequestBean request);
	boolean removeVehicleYearByYear(Integer vehicleYear);

}
