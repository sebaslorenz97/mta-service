package com.dulsystems.mta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.dao.QuoteDao;
import com.dulsystems.mta.dao.QuoteDetailDao;

@Service
public class QuoteDetailService implements IQuoteDetailService{
	
	@Autowired
	private QuoteDao quoteDao;
	
	@Autowired
	private QuoteDetailDao quoteDetailDao;

	@Override
	public ResponseBean searchQuoteDetailsById(Integer quoteDetail) {
		ResponseBean response = new ResponseBean();
		QuoteBean qb = quoteDao.searchQuoteById(quoteDetail);
		
		if(qb != null) {
			List<QuoteDetailBean> lqdb = quoteDetailDao.searchQuoteDetailById(quoteDetail);
			if(lqdb != null) {
				response.setCode("OK");
				response.setMessage("Si hay detalles de la cotizacion");
				response.setLQdb(lqdb);
			}else {
				response.setCode("BAD00");
				response.setMessage("No hay detalles de la cotizacion");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("No existe la cotizacion");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveQuoteDetails(RequestBean request) {
		ResponseBean response = new ResponseBean();
		//QuoteBean qb = quoteDao.searchQuoteById(request.getQuoteId());
		if(true/*qb != null*/) {
			if(quoteDetailDao.executeSaveQuoteDetail(request, /*qb,*/ request.getLqdb()).length > 0) {
				response.setCode("OK");
				response.setMessage("Se registraron los detalles de la cotizacion correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudieron actualizar los detalles correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El vehiculo no existe");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateQuoteDetailsById(RequestBean request) {
		ResponseBean response = new ResponseBean();
		//QuoteBean qb = quoteDao.searchQuoteById(request.getQuoteId());
		if(true/*qb != null*/) {
			if(quoteDetailDao.executeUpdateQuoteDetailById(request, /*qb,*/ request.getLqdb()).length > 0) {
				response.setCode("OK");
				response.setMessage("Se actualizaron los detalles de la cotizacion correctamente");
			
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudieron actualizar los detalles correctamente");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El vehiculo no existe");
		}
		return response;
	}

	@Override
	public ResponseBean removeQuoteDetailById(Integer quoteDetail) {
		ResponseBean response = new ResponseBean();
		if(quoteDetailDao.removeQuoteDetailById(quoteDetail)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
