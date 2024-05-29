package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.AddressCatalogsDao;

@Service
public class AddressCatalogsService implements IAddressCatalogs{
	
	@Autowired
	private AddressCatalogsDao addressCatalogsDao;

	//SERVICES FOR STATES
	@Override
	public ResponseBean searchStateByState(String state) {
		ResponseBean response = new ResponseBean();
		StateBean sb = new StateBean();
		sb = addressCatalogsDao.searchStateByState(state);
		if(sb != null) {
			response.setCode("OK");
			response.setMessage("Si existe estado");
			response.setSb(sb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe estado");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveState(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.executeSaveState(request) == true) {
			response.setCode("OK");
			response.setMessage("Se registro correctamente");
		
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo registrar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateStateByState(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.executeUpdateStateByState(request) == true) {
			response.setCode("OK");
			response.setMessage("Se actualizo correctamente");
		
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo actualizar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean removeStateByState(String state) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.removeStateByState(state)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

	//SERVICES FOR MUNICIPALITIES
	@Override
	public ResponseBean searchMunicipalityByMunicipality(String municipality) {
		ResponseBean response = new ResponseBean();
		MunicipalityBean mb = new MunicipalityBean();
		mb = addressCatalogsDao.searchMunicipalityByMunicipality(municipality);
		if(mb != null) {
			response.setCode("OK");
			response.setMessage("Si existe el municipio");
			response.setMb(mb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe el municipio");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveMunicipality(RequestBean request) {
		ResponseBean response = new ResponseBean();
		StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
		if(sb != null) {
			if(addressCatalogsDao.executeSaveMunicipality(request, sb) == true) {
				response.setCode("OK");
				response.setMessage("Se registro correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo registrar correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El estado no existe");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateMunicipalityByMunicipality(RequestBean request) {
		ResponseBean response = new ResponseBean();
		StateBean sb = addressCatalogsDao.searchStateByState(request.getStateNameFk());
		if(sb != null) {
			if(addressCatalogsDao.executeUpdateMunicipalityByMunicipality(request, sb) == true) {
				response.setCode("OK");
				response.setMessage("Se actualizo correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo actualizar correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El estado no existe");
		}
		return response;
	}

	@Override
	public ResponseBean removeMunicipalityByMunicipality(String municipality) {
		ResponseBean response = new ResponseBean();
		if(addressCatalogsDao.removeMunicipalityByMunicipality(municipality)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
