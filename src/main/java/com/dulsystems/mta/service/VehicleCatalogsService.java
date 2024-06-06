package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleLineBean;
import com.dulsystems.mta.bean.VehicleModelBean;
import com.dulsystems.mta.bean.VehicleYearBean;
import com.dulsystems.mta.dao.VehicleCatalogDao;
import com.dulsystems.mta.exception.BusinessException;

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
			response.setMessage("Consulta realizada");
			response.setVlb(vlb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe la marca");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicleLine(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLine())==null) {
			if(vehicleCatalogDao.executeSaveVehicleLine(request) == true) {
				response.setCode("OK");
				response.setMessage("Se guardo el registro");
			}else{
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Esa marca ya existe, intenta con otra");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleLineByLine(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLine())!=null) {
			if(vehicleCatalogDao.searchVehicleLineByLine(request.getNewVehicleLine())==null) {
				if(vehicleCatalogDao.executeUpdateVehicleLineByLine(request) == true) {
					response.setCode("OK");
					response.setMessage("Se actualizo el registro");
				
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Esa marca ya existe, intenta con otro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la marca que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleLineByLine(String vehicleLine) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleLineByLine(vehicleLine)!=null) {
			if(vehicleCatalogDao.removeVehicleLineByLine(vehicleLine)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque la marca no existe");
		}
        return response;
	}

	//SERVICES FOR VEHICLE MODELS
	@Override
	public ResponseBean searchVehicleModelByModel(String vehicleModel) {
		ResponseBean response = new ResponseBean();
		VehicleModelBean vmb = vehicleCatalogDao.searchVehicleModelByModel(vehicleModel);
		if(vmb != null) {
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			vmb.setVehicleLineNameFk(vehicleCatalogDao.searchVehicleLineById(vmb.getVehicleLineIdFk()).getVehicleLineName());
			response.setVmb(vmb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el modelo");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicleModel(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleModelByModel(request.getVehicleModel())==null) {
			VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
			if(vlb != null) {
				if(vehicleCatalogDao.executeSaveVehicleModel(request, vlb) == true) {
					response.setCode("OK");
					response.setMessage("Se guardo el registro");
				
				}else{
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la marca");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese modelo ya existe, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleModelByModel(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleModelByModel(request.getVehicleModel())!=null) {
			if(vehicleCatalogDao.searchVehicleModelByModel(request.getNewVehicleModel())==null) {
				VehicleLineBean vlb = vehicleCatalogDao.searchVehicleLineByLine(request.getVehicleLineNameFk());
				if(vlb != null) {
					if(vehicleCatalogDao.executeUpdateVehicleModelByModel(request, vlb) == true) {
						response.setCode("OK");
						response.setMessage("Se actualizo el registro");
					}else{
						throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la marca");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese modelo ya existe, intenta con otro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el modelo que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleModelByModel(String vehicleModel) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleModelByModel(vehicleModel)!=null) {
			if(vehicleCatalogDao.removeVehicleModelByModel(vehicleModel)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el modelo no existe");
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
			response.setMessage("Consulta realizada");
			response.setVyb(vyb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el año");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveVehicleYear(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleYearByYear(request.getVehicleYearValue())==null) {
			if(vehicleCatalogDao.executeSaveVehicleYear(request) == true) {
				response.setCode("OK");
				response.setMessage("Se guardo el registro");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese año ya existe, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateVehicleYearByYear(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleYearByYear(request.getVehicleYearValue())!=null) {
			if(vehicleCatalogDao.searchVehicleYearByYear(request.getNewVehicleYearValue())==null) {
				if(vehicleCatalogDao.executeUpdateVehicleYearByYear(request) == true) {
					response.setCode("OK");
					response.setMessage("Se actualizo el registro");
				
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese año ya existe, intenta con otro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el año que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeVehicleYearByYear(Integer vehicleYear) {
		ResponseBean response = new ResponseBean();
		if(vehicleCatalogDao.searchVehicleYearByYear(vehicleYear)!=null) {
			if(vehicleCatalogDao.removeVehicleYearByYear(vehicleYear)) {
				response.setCode("OK");
				response.setMessage("Se elimino correctamente");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el año no existe");
		}
        return response;
	}

}