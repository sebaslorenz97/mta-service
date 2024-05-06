package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.MunicipalityBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.MunicipalityDao;
import com.dulsystems.mta.dao.StateDao;

@Service
public class MunicipalityService implements IMunicipalityService{
	
	@Autowired
	private MunicipalityDao municipalityDao;
	
	@Autowired
	private StateDao stateDao;

	@Override
	public ResponseBean searchMunicipalityByMunicipality(String municipality) {
		ResponseBean response = new ResponseBean();
		MunicipalityBean mb = new MunicipalityBean();
		mb = municipalityDao.searchMunicipalityByMunicipality(municipality);
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
		StateBean sb = stateDao.searchStateByState(request.getStateNameFk());
		if(sb != null) {
			if(municipalityDao.executeSaveMunicipality(request, sb) == true) {
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
		StateBean sb = stateDao.searchStateByState(request.getStateNameFk());
		if(sb != null) {
			if(municipalityDao.executeUpdateMunicipalityByMunicipality(request, sb) == true) {
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
		if(municipalityDao.removeMunicipalityByMunicipality(municipality)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
