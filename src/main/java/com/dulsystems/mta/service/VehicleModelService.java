package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.dao.VehicleLineDao;
import com.dulsystems.mta.dao.VehicleModelDao;

@Service
public class VehicleModelService implements IVehicleModelService{
	
	@Autowired
	private VehicleModelDao vehicleModelDao;
	
	@Autowired
	private VehicleLineDao vehicleLineDao;

	@Override
	public ResponseBean searchVehicleModelByModel(String vehicleModel) {
		ResponseBean response = new ResponseBean();
		VehicleModelBean vmb = new VehicleModelBean();
		vmb = vehicleModelDao.searchVehicleModelByModel(vehicleModel);
		if(vmb != null) {
			response.setCode("OK");
			response.setMessage("Si existe el modelo");
			response.setVmb(vmb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe el modelo");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicleModel(RequestBean request) {
		ResponseBean response = new ResponseBean();
		VehicleLineBean vlb = vehicleLineDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
		if(vlb != null) {
			if(vehicleModelDao.executeSaveVehicleModel(request, vlb) == true) {
				response.setCode("OK");
				response.setMessage("Se registro correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo registrar correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("No existe la marca");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleModelByModel(RequestBean request) {
		ResponseBean response = new ResponseBean();
		VehicleLineBean vlb = vehicleLineDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
		if(vlb != null) {
			if(vehicleModelDao.executeUpdateVehicleModelByModel(request, vlb) == true) {
				response.setCode("OK");
				response.setMessage("Se actualizo correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo actualizar correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("No existe la marca");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleModelByModel(String vehicleModel) {
		ResponseBean response = new ResponseBean();
		if(vehicleModelDao.removeVehicleModelByModel(vehicleModel)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
