package com.dulsystems.mta.dao;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleYearBean;

public interface IVehicleYearDao {
	
	VehicleYearBean searchVehicleYearByYear(Integer vehicleYear);
	
	boolean executeSaveVehicleYear(RequestBean request);
	
	boolean executeUpdateVehicleYearByYear(RequestBean request);
	
	boolean removeVehicleYearByYear(Integer vehicleYear);

}
