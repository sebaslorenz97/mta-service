package com.dulsystems.mta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.QuoteBean;
import com.dulsystems.mta.bean.QuoteDetailBean;
import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.VehicleBean;
import com.dulsystems.mta.dao.QuoteDetailDao;
import com.dulsystems.mta.dao.VehicleDao;
import com.dulsystems.mta.exception.BusinessException;

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
		if(quoteDetailDao.searchQuoteById(id)!=null) {
			if(quoteDetailDao.removeQuoteById(id)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
				
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
	public ResponseBean searchQuoteDetailsByQuoteId(Integer quoteDetail) {
		ResponseBean response = new ResponseBean();
		if(quoteDetailDao.searchQuoteById(quoteDetail) != null) {
			List<QuoteDetailBean> lqdb = quoteDetailDao.searchQuoteDetailsByQuoteId(quoteDetail);
			if(lqdb.size() > 0) {
				response.setCode("OK");
				response.setMessage("Consulta realizada");
				response.setLQdb(lqdb);
			}else {
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existen detalles de la cotizacion");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la cotizacion");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveQuoteDetails(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(quoteDetailDao.searchQuoteById(request.getLqdb().get(0).getQuoteDetailIdFk()) != null) {
			if(quoteDetailDao.executeSaveQuoteDetails(request, request.getLqdb()).length > 0) {
				response.setCode("OK");
				response.setMessage("Se guardaron los detalles de la cotizacion");
				response.setLQdb(request.getLqdb());
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron guardar los detalles de la cotizacion");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la cotizacion");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateQuoteDetailsByQuoteId(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(quoteDetailDao.searchQuoteById(request.getLqdb().get(0).getQuoteDetailIdFk()) != null) {
			if(quoteDetailDao.executeUpdateQuoteDetailsByQuoteId(request, request.getLqdb()).length > 0) {
				response.setCode("OK");
				response.setMessage("Se actualizaron los detalles de la cotizacion");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron actualizar los detalles de la cotizacion");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe la cotizacion");
		}
		return response;
	}

	@Override
	public ResponseBean removeQuoteDetailsByQuoteId(Integer quoteDetail) {
		ResponseBean response = new ResponseBean();
		if(quoteDetailDao.searchQuoteById(quoteDetail) != null) {
			if(quoteDetailDao.removeQuoteDetailsByQuoteId(quoteDetail)) {
				response.setCode("OK");
				response.setMessage("Se eliminaron los detalles de la cotizacion");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudieron eliminar los detalles de la cotizacion");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque los detalles de la cotizacion no existen");
		}
        return response;
	}

}
