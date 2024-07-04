package com.dulsystems.mta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.dao.QuoteDetailDao;
import com.dulsystems.mta.dao.VehicleDao;
import com.dulsystems.mta.exception.BusinessException;
import com.dulsystems.mta.util.Queries;

@Service
public class QuoteDetailService implements IQuoteDetailService{
	
	@Autowired
	private QuoteDetailDao quoteDetailDao;
	
	@Autowired
	private VehicleDao vehicleDao;
	
	//SERVICES FOR QUOTE
	@Override
	public ResponseBean searchQuoteById(Integer id) {
		ResponseBean response = new ResponseBean();
		QuoteBean qb = new QuoteBean();
		qb = quoteDetailDao.searchQuoteById(id);
		if(qb != null) {
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			response.setQb(qb);
			
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe la cotizacion");
		}
		searchQuoteDetailsByQuoteId(id, response);
		return response;
	}
	
	@Override
	public ResponseBean searchVehicleQuotesByVehiclePlate(String vehiclePlate) {
		ResponseBean response = new ResponseBean();
		VehicleBean vb = vehicleDao.searchVehicleByPlate(vehiclePlate);
		if(vb != null) {
			List<QuoteBean> lqb = quoteDetailDao.searchVehicleQuotesByVehicleId(vb.getVehicleId());
			if(lqb.size() > 0) {
				response.setCode("OK");
				response.setMessage("Consulta realizada");
				response.setLqb(lqb);
			}else {
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"El vehiculo no tiene cotizaciones");
			}
		}else{
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el vehiculo");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveQuote(RequestBean request) {
		ResponseBean response = new ResponseBean();
		VehicleBean vb = vehicleDao.searchVehicleByPlate(request.getVehiclePlate());
		if(vb != null) {
			if(quoteDetailDao.executeSaveQuote(request, vb) == true) {
				response.setCode("OK");
				response.setMessage("Se guardo el registro");
				response.setQb(quoteDetailDao.searchLastQuoteCreated(request, vehicleDao.searchVehicleByPlate(request.getVehiclePlate()).getVehicleId()));
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el vehiculo");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateQuoteById(RequestBean request) {
		ResponseBean response = new ResponseBean();
		System.out.println("COTIZACION QUE SE QUIRE ACTUALIZAR -------> " + request.getQuoteId());
		if(quoteDetailDao.searchQuoteById(request.getQuoteId())!=null) {
			VehicleBean vb = vehicleDao.searchVehicleByPlate(request.getVehiclePlate());
			if(vb != null) {
				if(quoteDetailDao.executeUpdateQuoteById(request, vb) == true) {
					response.setCode("OK");
					response.setMessage("Se actualizo el registro");
				
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el vehiculo");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la cotizacion que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeQuoteById(Integer id) {
		ResponseBean response = new ResponseBean();
		removeQuoteDetailsByQuoteId(id, response);
		if(quoteDetailDao.searchQuoteById(id)!=null) {
			if(quoteDetailDao.removeQuoteById(id)) {
				response.setCode("OK");
				response.setMessage("Se elimino la cotizacion");
				
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo eliminar correctamente");
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque la cotizacion no existe");
		}
        return response;
	}
	
	//SERVICES FOR DETAILS OF A QUOTE
	@Override
	public ResponseBean searchQuoteDetailsByQuoteId(Integer quoteDetail, ResponseBean response) {
		if(response == null) {
			response = new ResponseBean();
		}
		if(quoteDetailDao.searchQuoteById(quoteDetail) != null) {
			List<QuoteDetailBean> lqdb = quoteDetailDao.searchQuoteDetailsByQuoteId(quoteDetail);
			if(lqdb.size() > 0) {
				response.setCode("OK");
				response.setMessage("Consulta realizada");
				response.setLQdb(lqdb);
			}else {
				response.setCode("OK");
				response.setMessage("No existen detalles de la cotizacion");
				response.setLQdb(lqdb);
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la cotizacion");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveEditAndDeleteQuoteDetailsByDetailId(RequestBean request) {
		ResponseBean response = new ResponseBean();
		List<QuoteDetailBean> lqdbForUpdate = new ArrayList<QuoteDetailBean>();
		List<QuoteDetailBean> lqdbForSave = new ArrayList<QuoteDetailBean>();
		for(QuoteDetailBean qdb : request.getLqdb()) {
			if(qdb.getQuoteDetailId() != null) {
				lqdbForUpdate.add(qdb);
			}else {
				lqdbForSave.add(qdb);
			}
		}
		
		//SAVE NEW DETAILS
		if(lqdbForSave.size()>0) {
			if(quoteDetailDao.searchQuoteById(request.getLqdb().get(0).getQuoteDetailIdFk()) != null) {
				if(quoteDetailDao.executeSaveQuoteDetails(request, lqdbForSave).length > 0) {
					response.setCode("OK");
					response.setMessage("Se guardaron los detalles de la cotizacion");
					response.setLQdb(request.getLqdb());
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron guardar los detalles de la cotizacion");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se guardo porque la cotizacion no existe");
			}
		}
		
		
		//UPDATE DETAILS
		if(lqdbForUpdate.size() > 0) {
			executeUpdateQuoteDetailsByDetailId(request, lqdbForUpdate, response);
		}
		
		//DELETE DETAILS
		if(request.getLqdbForDelete().length > 0) {
			removeQuoteDetailsByDetailId(request, request.getLqdbForDelete(), response);
		}
		
		return response;
	}

	@Override
	public ResponseBean executeUpdateQuoteDetailsByDetailId(RequestBean request, List<QuoteDetailBean> lqdbForUpdate, ResponseBean response) {
		if(response == null) {
			response = new ResponseBean();
		}
		
		int[] lqdbUpdated;
		if(quoteDetailDao.searchQuoteById(request.getLqdb().get(0).getQuoteDetailIdFk()) != null) {
			if(lqdbForUpdate != null) {
				lqdbUpdated = quoteDetailDao.executeUpdateQuoteDetailsByDetailId(request, lqdbForUpdate);
			}else {
				lqdbUpdated = quoteDetailDao.executeUpdateQuoteDetailsByDetailId(request, request.getLqdb());
			}
			if(lqdbUpdated.length > 0) {
				response.setCode("OK");
				response.setMessage("Se actualizaron los detalles de la cotizacion");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron actualizar los detalles de la cotizacion");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se actualizo porque la cotizacion no existe");
		}
		return response;
	}
	
	@Override
	public ResponseBean removeQuoteDetailsByDetailId(RequestBean request, int[] lqdbForDelete, ResponseBean response) {
		/*StringBuilder stringB = new StringBuilder();
		stringB.append(Queries.Q_QUOTE_DETAILS_REMOVE_BY_DETAIL_ID_2);
		completeQuery(stringB, lqdbForDelete);
		System.out.println("FINAL QUERY ---------> "+ stringB.toString());*/
		
		if(response == null) {
			response = new ResponseBean();
		}
		if(quoteDetailDao.searchQuoteById(request.getLqdb().get(0).getQuoteDetailIdFk()) != null) {
			if(quoteDetailDao.removeQuoteDetailsByDetailId(lqdbForDelete/*, stringB.toString()*/).length > 0) {
				response.setCode("OK");
				response.setMessage("Se eliminaron los detalles de la cotizacion");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron eliminar los detalles de la cotizacion");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque la cotizacion no existe");
		}
        return response;
	}

	@Override
	public ResponseBean removeQuoteDetailsByQuoteId(Integer quoteDetail, ResponseBean response) {
		if(response == null) {
			response = new ResponseBean();
		}
		if(quoteDetailDao.searchQuoteById(quoteDetail) != null) {
			if(quoteDetailDao.searchQuoteDetailsByQuoteId(quoteDetail).size() > 0) {
				if(quoteDetailDao.removeQuoteDetailsByQuoteId(quoteDetail)) {
					response.setCode("OK");
					response.setMessage("Se eliminaron los detalles de la cotizacion");
					
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron eliminar los detalles de la cotizacion");
				}
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque la cotizacion no existe");
		}
        return response;
	}
	
	//HELPER METHODS
	/*
	//METHOD FOR CREATE A FINAL QUERY BASED ON THE LENGTH OF AN ARRAY 
	public void completeQuery(StringBuilder stringB, int[] lqdbForDelete) {
		for(int i = 0; i < lqdbForDelete.length; i++) {
			if(i == (lqdbForDelete.length -1)) {
				stringB.append("?");
			}else {
				stringB.append("?,");
			}
		}
		stringB.append(");");
	}*/

}
