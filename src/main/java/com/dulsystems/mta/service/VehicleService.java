package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.CustomerDao;
import com.dulsystems.mta.dao.VehicleCatalogDao;
import com.dulsystems.mta.dao.VehicleDao;

@Service
public class VehicleService implements IVehicleService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private VehicleCatalogDao vehicleCatalogDao; 
	
	@Override
	public ResponseBean searchVehicleByPlate(String plate) {
		ResponseBean response = new ResponseBean();
		VehicleBean vb = new VehicleBean();
		vb = vehicleDao.searchVehicleByPlate(plate);
		if(vb != null) {
			response.setCode("OK");
			response.setMessage("Si existe el vehiculo");
			System.out.println("SI EXISTE EL VEHICULO!!!!!!!!!!!!!!!!!!!!!");;
			response.setVb(vb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe el vehiculo");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicle(RequestBean request) {
		ResponseBean response = new ResponseBean();
		CustomerBean cb = customerDao.searchCustomerById(request.getCustomerIdFk());
		VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
		VehicleModelBean vmb = vehicleCatalogDao.searchVehicleModelByModel(request.getVehicleModelNameFk());
		VehicleYearBean vyb = vehicleCatalogDao.searchVehicleYearByYear(request.getVehicleYearValueFk());
		if(cb != null) {
			if(vlb != null) {
				if(vmb != null) {
					if(vyb != null) {
						if(vehicleDao.executeSaveVehicle(request, cb, vlb, vmb, vyb) == true) {
							response.setCode("OK");
							response.setMessage("Se registro correctamente");
						
						}else{
							response.setCode("BAD00");
							response.setMessage("No se pudo registrar correctamente");
						}
					}else {
						response.setCode("BAD01");
						response.setMessage("El año no existe");
					}
				}else {
					response.setCode("BAD01");
					response.setMessage("El modelo no existe");
				}
			}else {
				response.setCode("BAD01");
				response.setMessage("La marca no existe");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El cliente no existe");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleByPlate(RequestBean request) {
		ResponseBean response = new ResponseBean();
		CustomerBean cb = customerDao.searchCustomerById(request.getCustomerIdFk());
		VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
		VehicleModelBean vmb = vehicleCatalogDao.searchVehicleModelByModel(request.getVehicleModelNameFk());
		VehicleYearBean vyb = vehicleCatalogDao.searchVehicleYearByYear(request.getVehicleYearValueFk());
		if(cb != null) {
			if(vlb != null) {
				if(vmb != null) {
					if(vyb != null) {
						if(vehicleDao.executeUpdateVehicleByPlate(request, cb, vlb, vmb, vyb) == true) {
							response.setCode("OK");
							response.setMessage("Se actualizo correctamente");
						}else{
							response.setCode("BAD00");
							response.setMessage("No se pudo actualizar correctamente");
						}
					}else {
						response.setCode("BAD01");
						response.setMessage("El año no existe");
					}
				}else {
					response.setCode("BAD01");
					response.setMessage("El modelo no existe");
				}
			}else {
				response.setCode("BAD01");
				response.setMessage("La marca no existe");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El cliente no existe");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleByPlate(String plate) {
		ResponseBean response = new ResponseBean();
		if(vehicleDao.removeVehicleByPlate(plate)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}
	
}