package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.StateBean;
import com.dulsystems.mta.dao.StateDao;

@Service
public class StateService implements IStateService {
	
	@Autowired
	private StateDao stateDao;

	@Override
	public ResponseBean searchStateByState(String state) {
		ResponseBean response = new ResponseBean();
		StateBean sb = new StateBean();
		sb = stateDao.searchStateByState(state);
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
		if(stateDao.executeSaveState(request) == true) {
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
		if(stateDao.executeUpdateStateByState(request) == true) {
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
		if(stateDao.removeStateByState(state)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
