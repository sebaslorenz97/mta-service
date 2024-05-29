package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.VehicleCatalogDao;

@Service
public class VehicleCatalogsService implements IVehicleCatalogsService{
	
	@Autowired
	private VehicleCatalogDao vehicleCatalogDao; 

	//SERVICES FOR VEHICLE LINES
	@Override
	public ResponseBean searchVehicleLineByLine(String vehicleLine) {
		ResponseBean response = new ResponseBean();
		VehicleLineBean vlb = new VehicleLineBean();
		vlb = vehicleCatalogDao.searchVehicleLineByLine(vehicleLine);
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
		if(vehicleCatalogDao.executeSaveVehicleLine(request) == true) {
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
		if(vehicleCatalogDao.executeUpdateVehicleLineByLine(request) == true) {
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
		if(vehicleCatalogDao.removeVehicleLineByLine(vehicleLine)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

	//SERVICES FOR VEHICLE MODELS
	@Override
	public ResponseBean searchVehicleModelByModel(String vehicleModel) {
		ResponseBean response = new ResponseBean();
		VehicleModelBean vmb = new VehicleModelBean();
		vmb = vehicleCatalogDao.searchVehicleModelByModel(vehicleModel);
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
		VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
		if(vlb != null) {
			if(vehicleCatalogDao.executeSaveVehicleModel(request, vlb) == true) {
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
		VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
		if(vlb != null) {
			if(vehicleCatalogDao.executeUpdateVehicleModelByModel(request, vlb) == true) {
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
		if(vehicleCatalogDao.removeVehicleModelByModel(vehicleModel)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

	//SERVICES FOR VEHICLE YEARS
	@Override
	public ResponseBean searchVehicleYearByYear(Integer vehicleYear) {
		ResponseBean response = new ResponseBean();
		VehicleYearBean vyb = new VehicleYearBean();
		vyb = vehicleCatalogDao.searchVehicleYearByYear(vehicleYear);
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
		if(vehicleCatalogDao.executeSaveVehicleYear(request) == true) {
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
		if(vehicleCatalogDao.executeUpdateVehicleYearByYear(request) == true) {
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
		if(vehicleCatalogDao.removeVehicleYearByYear(vehicleYear)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
