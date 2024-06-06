package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.AddressCatalogsDao;
import com.dulsystems.mta.dao.CustomerDao;
import com.dulsystems.mta.exception.BusinessException;
import com.dulsystems.mta.util.Queries;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AddressCatalogsDao addressCatalogsDao;
	

	@Override
	public ResponseBean searchCustomerByName(String name) {
		ResponseBean response = new ResponseBean();
		CustomerBean cb = new CustomerBean();
		cb = customerDao.searchCustomerByName(name);
		if(cb != null) {
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			response.setCb(cb);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el cliente");
		}
		return response;
	}
	
	@Override
	public ResponseBean executeSaveCustomer(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(customerDao.searchCustomerByName(request.getCustomerName())==null) {
			StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
			MunicipalityBean mb = addressCatalogsDao.searchMunicipalityByMunicipality(request.getMunicipalityNameFk());
			if(sb != null) {
				if(mb != null) {
					if(customerDao.executeSaveCustomer(request, sb, mb) == true) {
						response.setCode("OK");
						response.setMessage("Se guardo el registro");
						response.setCb(customerDao.searchCustomerByName(request.getCustomerName()));
					}else{
						throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese cliente ya existe, intenta con otro");
		}
		return response;
	}
	
	@Override
	public ResponseBean executeUpdateCustomerByName(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(customerDao.searchCustomerByName(request.getCustomerName())!=null) {
			if(customerDao.searchCustomerByName(request.getNewCustomerName())==null) {
				StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
				MunicipalityBean mb = addressCatalogsDao.searchMunicipalityByMunicipality(request.getMunicipalityNameFk());
				if(sb != null) {
					if(mb != null) {
						if(customerDao.executeUpdateCustomerByName(request, sb, mb) == true) {
							response.setCode("OK");
							response.setMessage("Se actualizo el registro");
						}else{
							throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
						}
					}else {
						throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese cliente ya existe, intenta con otro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el cliente que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeCustomerByName(String name) {
		ResponseBean response = new ResponseBean();
		if(customerDao.searchCustomerByName(name)!=null){
			if(customerDao.removeCustomerByName(name)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el cliente no existe");
		}
        return response;
	}
	
}