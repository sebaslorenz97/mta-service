package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.dulsystems.mta.exception.BusinessException;

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
			response.setMessage("Consulta realizada");
			response.setVb(vb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el vehiculo");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicle(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleDao.searchVehicleByPlate(request.getVehiclePlate())==null) {
			CustomerBean cb = customerDao.searchCustomerByName(request.getCustomerNameFk());
			VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
			VehicleModelBean vmb = vehicleCatalogDao.searchVehicleModelByModel(request.getVehicleModelNameFk());
			VehicleYearBean vyb = vehicleCatalogDao.searchVehicleYearByYear(request.getVehicleYearValueFk());
			if(cb != null) {
				if(vlb != null) {
					if(vmb != null) {
						if(vyb != null) {
							if(vehicleDao.executeSaveVehicle(request, cb, vlb, vmb, vyb) == true) {
								response.setCode("OK");
								response.setMessage("Se guardo el registro");
								response.setVb(vehicleDao.searchVehicleByPlate(request.getVehiclePlate()));
							
							}else{
								throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
							}
						}else {
							throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el año");
						}
					}else {
						throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el modelo");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la marca");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el cliente");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese vehiculo ya existe, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleByPlate(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleDao.searchVehicleByPlate(request.getVehiclePlate())!=null) {
			if(vehicleDao.searchVehicleByPlate(request.getNewVehiclePlate())==null) {
				CustomerBean cb = customerDao.searchCustomerByName(request.getCustomerNameFk());
				VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
				VehicleModelBean vmb = vehicleCatalogDao.searchVehicleModelByModel(request.getVehicleModelNameFk());
				VehicleYearBean vyb = vehicleCatalogDao.searchVehicleYearByYear(request.getVehicleYearValueFk());
				if(cb != null) {
					if(vlb != null) {
						if(vmb != null) {
							if(vyb != null) {
								if(vehicleDao.executeUpdateVehicleByPlate(request, cb, vlb, vmb, vyb) == true) {
									response.setCode("OK");
									response.setMessage("Se actualizo el registro");
								}else{
									throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
								}
							}else {
								throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el año");
							}
						}else {
							throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el modelo");
						}
					}else {
						throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la marca");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el cliente");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese vehiculo ya existe, intenta con otro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el vehiculo que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleByPlate(String plate) {
		ResponseBean response = new ResponseBean();
		if(vehicleDao.searchVehicleByPlate(plate)!=null) {
			if(vehicleDao.removeVehicleByPlate(plate)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el vehiculo no existe");
		}
        return response;
	}
	
}