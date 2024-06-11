package com.dulsystems.mta.dao;

import java.util.List;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;

public interface IVehicleDao {
	
	VehicleBean searchVehicleByPlate(String plate);
	
	List<VehicleBean> searchCustomerVehiclesByCustomerName(Integer customerId);
	
	boolean executeSaveVehicle(RequestBean request, CustomerBean cb, VehicleLineBean vlb, VehicleModelBean vmb, VehicleYearBean vyb);
	
	boolean executeUpdateVehicleByPlate(RequestBean request, CustomerBean cb, VehicleLineBean vlb, VehicleModelBean vmb, VehicleYearBean vyb);
	
	boolean removeVehicleByPlate(String plate);

}
