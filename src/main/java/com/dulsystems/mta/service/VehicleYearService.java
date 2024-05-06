package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.VehicleYearDao;

@Service
public class VehicleYearService implements IVehicleYearService{
	
	@Autowired
	private VehicleYearDao vehicleYearDao;

	@Override
	public ResponseBean searchVehicleYearByYear(Integer vehicleYear) {
		ResponseBean response = new ResponseBean();
		VehicleYearBean vyb = new VehicleYearBean();
		vyb = vehicleYearDao.searchVehicleYearByYear(vehicleYear);
		if(vyb != null) {
			response.setCode("OK");
			response.setMessage("Si existe el año");
			response.setVyb(vyb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe el año");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicleYear(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleYearDao.executeSaveVehicleYear(request) == true) {
			response.setCode("OK");
			response.setMessage("Se registro correctamente");
		
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo registrar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleYearByYear(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleYearDao.executeUpdateVehicleYearByYear(request) == true) {
			response.setCode("OK");
			response.setMessage("Se actualizo correctamente");
		
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo actualizar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleYearByYear(Integer vehicleYear) {
		ResponseBean response = new ResponseBean();
		if(vehicleYearDao.removeVehicleYearByYear(vehicleYear)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}
	
}
