package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.AddressCatalogsDao;
import com.dulsystems.mta.dao.CustomerDao;
import com.dulsystems.mta.util.Queries;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AddressCatalogsDao addressCatalogsDao;
	

	@Override
	public ResponseBean searchCustomerById(Integer id) {
		ResponseBean response = new ResponseBean();
		CustomerBean cb = new CustomerBean();
		cb = customerDao.searchCustomerById(id);
		if(cb != null) {
			response.setCode("OK");
			response.setMessage("Si existe el cliente");
			response.setCb(cb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe el cliente");
		}
		return response;
	}
	
	@Override
	public ResponseBean executeSaveCustomer(RequestBean request) {
		ResponseBean response = new ResponseBean();
		StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
		MunicipalityBean mb = addressCatalogsDao.searchMunicipalityByMunicipality(request.getMunicipalityNameFk());
		if(sb != null) {
			if(mb != null) {
				if(customerDao.executeSaveCustomer(request, sb, mb) == true) {
					response.setCode("OK");
					response.setMessage("Se registro correctamente");
				
				}else{
					response.setCode("BAD00");
					response.setMessage("No se pudo registrar correctamente");
				}
			}else {
				response.setCode("BAD01");
				response.setMessage("El municipio no existe");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El estado no existe");
		}
		return response;
	}
	
	@Override
	public ResponseBean executeUpdateCustomerById(RequestBean request) {
		ResponseBean response = new ResponseBean();
		StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
		MunicipalityBean mb = addressCatalogsDao.searchMunicipalityByMunicipality(request.getMunicipalityNameFk());
		if(sb != null) {
			if(mb != null) {
				if(customerDao.executeUpdateCustomerById(request, sb, mb) == true) {
					response.setCode("OK");
					response.setMessage("Se actualizo correctamente");
				}else{
					response.setCode("BAD00");
					response.setMessage("No se pudo actualizar correctamente");
				}
			}else {
				response.setCode("BAD01");
				response.setMessage("El municipio no existe");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El estado no existe");
		}
		return response;
	}

	@Override
	public ResponseBean removeCustomerById(Integer id) {
		ResponseBean response = new ResponseBean();
		if(customerDao.removeCustomerById(id)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}
	
}