package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.CustomerBean;
import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.dao.QuoteDao;
import com.dulsystems.mta.dao.VehicleDao;

@Service
public class QuoteService implements IQuoteService{
	
	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private QuoteDao quoteDao;

	@Override
	public ResponseBean searchQuoteById(Integer id) {
		ResponseBean response = new ResponseBean();
		QuoteBean qb = new QuoteBean();
		qb = quoteDao.searchQuoteById(id);
		if(qb != null) {
			response.setCode("OK");
			response.setMessage("Si existe la cotizacion");
			response.setQb(qb);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe la cotizacion");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveQuote(RequestBean request) {
		ResponseBean response = new ResponseBean();
		VehicleBean vb = vehicleDao.searchVehicleByPlate(request.getVehiclePlate());
		if(vb != null) {
			if(quoteDao.executeSaveQuote(request, vb) == true) {
				response.setCode("OK");
				response.setMessage("Se registro correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo registrar correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El vehiculo no existe");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateQuoteById(RequestBean request) {
		ResponseBean response = new ResponseBean();
		VehicleBean vb = vehicleDao.searchVehicleByPlate(request.getVehiclePlate());
		if(vb != null) {
			if(quoteDao.executeUpdateQuoteById(request, vb) == true) {
				response.setCode("OK");
				response.setMessage("Se actualizo correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo actualizar correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El vehiculo no existe");
		}
		return response;
	}

	@Override
	public ResponseBean removeQuoteById(Integer id) {
		ResponseBean response = new ResponseBean();
		if(quoteDao.removeQuoteById(id)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
