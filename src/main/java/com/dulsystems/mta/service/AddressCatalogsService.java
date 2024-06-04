package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.AddressCatalogsDao;
import com.dulsystems.mta.exception.BusinessException;

@Service
public class AddressCatalogsService implements IAddressCatalogs{
	
	@Autowired
	private AddressCatalogsDao addressCatalogsDao;

	//SERVICES FOR STATES
	@Override
	public ResponseBean searchStateByState(String state) {
		ResponseBean response = new ResponseBean();
		StateBean sb = addressCatalogsDao.searchStateByState(state);
		if(sb != null) {
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			response.setSb(sb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el estado");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveState(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.searchStateByState(request.getStateName())==null) {
			if(addressCatalogsDao.executeSaveState(request) == true) {
				response.setCode("OK");
				response.setMessage("Se guardo el registro");
			
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese estado ya existe, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateStateByState(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.searchStateByState(request.getStateName())!=null) {
			if(addressCatalogsDao.searchStateByState(request.getNewStateName())==null) {
				if(addressCatalogsDao.executeUpdateStateByState(request) == true) {
					response.setCode("OK");
					response.setMessage("Se actualizo el registro");
				
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese estado ya existe, intenta con otro");
			}
		}else{
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeStateByState(String state) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.searchStateByState(state)!=null) {
			if(addressCatalogsDao.removeStateByState(state)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else{
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el estado no existe");
		}
        return response;
	}

	//SERVICES FOR MUNICIPALITIES
	@Override
	public ResponseBean searchMunicipalityByMunicipality(String municipality) {
		ResponseBean response = new ResponseBean();
		MunicipalityBean mb = addressCatalogsDao.searchMunicipalityByMunicipality(municipality);
		if(mb != null) {
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			response.setMb(mb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el municipio");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveMunicipality(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.searchMunicipalityByMunicipality(request.getMunicipalityName())==null) {
			StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
			if(sb != null) {
				if(addressCatalogsDao.executeSaveMunicipality(request, sb) == true) {
					response.setCode("OK");
					response.setMessage("Se guardo el registro");
				
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese municipio ya existe, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateMunicipalityByMunicipality(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.searchMunicipalityByMunicipality(request.getMunicipalityName())!=null) {
			if(addressCatalogsDao.searchMunicipalityByMunicipality(request.getNewMunicipalityName())==null) {
				StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
				if(sb != null) {
					if(addressCatalogsDao.executeUpdateMunicipalityByMunicipality(request, sb) == true) {
						response.setCode("OK");
						response.setMessage("Se actualizo el registro");
					
					}else{
						throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese municipio ya existe, intenta con otro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeMunicipalityByMunicipality(String municipality) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.searchMunicipalityByMunicipality(municipality)!=null) {
			if(addressCatalogsDao.removeMunicipalityByMunicipality(municipality)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el municipio no existe");
		}
        return response;
	}

}
