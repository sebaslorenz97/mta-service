package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.dao.VehicleLineDao;

@Service
public class VehicleLineService implements IVehicleLineService{
	
	@Autowired
	private VehicleLineDao vehicleLineDao;

	@Override
	public ResponseBean searchVehicleLineByLine(String vehicleLine) {
		ResponseBean response = new ResponseBean();
		VehicleLineBean vlb = new VehicleLineBean();
		vlb = vehicleLineDao.searchVehicleLineByLine(vehicleLine);
		if(vlb != null) {
			response.setCode("OK");
			response.setMessage("Si existe la marca del auto");
			response.setVlb(vlb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe la marca del auto");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicleLine(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleLineDao.executeSaveVehicleLine(request) == true) {
			response.setCode("OK");
			response.setMessage("Se registro correctamente");
		
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo registrar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleLineByLine(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleLineDao.executeUpdateVehicleLineByLine(request) == true) {
			response.setCode("OK");
			response.setMessage("Se actualizo correctamente");
		
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo actualizar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleLineByLine(String vehicleLine) {
		ResponseBean response = new ResponseBean();
		if(vehicleLineDao.removeVehicleLineByLine(vehicleLine)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
