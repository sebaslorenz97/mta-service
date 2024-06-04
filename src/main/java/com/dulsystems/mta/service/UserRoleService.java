package com.dulsystems.mta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.bean.UserRoleBean;
import com.dulsystems.mta.dao.UserRoleDao;
import com.dulsystems.mta.exception.BusinessException;

@Service
public class UserRoleService implements IUserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;

	//METHODS FOR USER
	@Override
	public ResponseBean searchUserByUser(String user) {
		ResponseBean response = new ResponseBean();
		UserBean ub = new UserBean();
		ub = userRoleDao.searchUserByUser(user);
		if(ub != null) {
			ub.setUserPassword(""); //THIS ENDPOINT MUST NOT RETURN THE PASSWORD SO WE REMOVE IT HERE
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			response.setUb(ub);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el usuario");
		}
		return response;
	}
	
	@Override
	public ResponseBean executeSaveUser(RequestBean request) {
		ResponseBean response = new ResponseBean();
		UserBean ub = userRoleDao.searchUserByUser(request.getUserPk());
		if(ub == null) {
			if(userRoleDao.executeSaveUser(request) == true) {
				response.setCode("OK");
				response.setMessage("Se guardo el registro");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese usuario ya existe, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateUserByUserForAdmin(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.searchUserByUser(request.getUserPk())!=null) {
			if(userRoleDao.executeUpdateUserByUserForAdmin(request) == true) {
				response.setCode("OK");
				response.setMessage("Se actualizo el registro");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el usuario que quieres actualizar");
		}
		return response;
	}

	@Override
	public ResponseBean removeUserByUser(String user) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.searchUserByUser(user)!=null) {
			if(userRoleDao.removeUserByUser(user)) {
				response.setCode("OK");
				response.setMessage("Se elimino el registro");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el usuario no existe");
		}
        return response;
	}
	
	//METHODS FOR USER ROLES
	@Override
	public ResponseBean searchAllUserRoles(RequestBean request) {
		ResponseBean response = new ResponseBean();
		List<String> roles = userRoleDao.searchAllUserRoles(request);
		if(roles.size() > 0) {
			response.setCode("OK");
			response.setMessage("Consulta exitosa");
			response.setRoles(roles);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"Consulta fallida");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveUserRole(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.searchUserRoleByRoleAndUser(request) == null) {
			if(userRoleDao.searchUserByUser(request.getUserPkFk()) != null) {
				if(userRoleDao.executeSaveUserRole(request) == true) {
					response.setCode("OK");
					response.setMessage("Se asigno el rol al usuario");
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo asignar el rol al usuario");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el usuario");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese rol de usuario ya fue asignado, intenta con otro");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateUserRoleByRoleAndUser(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.searchUserByUser(request.getUserPkFk()) != null) {
			if(userRoleDao.searchUserRoleByRoleAndUser(request) != null) {
				if(userRoleDao.searchUserRoleByRoleAndUser(request) == null) {
					if(userRoleDao.executeUpdateUserRoleByRoleAndUser(request) == true) {
						response.setCode("OK");
						response.setMessage("Se actualizo el rol del usuario");
					}else{
						throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo reasignar el rol al usuario");
					}
				}else {
					throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese rol del usuario ya existe, intenta con otro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese rol de usuario no ha sido asignado");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el usuario");
		}
		return response;
		
	}

	@Override
	public ResponseBean removeUserRoleByRoleAndUser(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.searchUserRoleByRoleAndUser(request) != null) {
			if(userRoleDao.removeUserRoleByRoleAndUser(request)) {
				response.setCode("OK");
				response.setMessage("Se elimino el rol del usuario");
				
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el rol del usuario");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino el rol del usuario porque no existe");
		}
        return response;
	}

}
