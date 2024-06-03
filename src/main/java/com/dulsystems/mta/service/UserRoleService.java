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
			response.setMessage("Si existe el usuario");
			response.setUb(ub);
		}else {
			response.setCode("BAD00");
			response.setMessage("No existe el usuario");
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
				response.setMessage("Se registro correctamente");
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo registrar correctamente");
			}
			return response;
		}else {
			/*response.setCode("BAD00");
			response.setMessage("Ese usuario ya existe, intenta con otro");
			return response;*/
			throw new BusinessException("E-404",HttpStatus.BAD_REQUEST,"Ese usuario ya existe, intenta con otro");
		}
	}

	@Override
	public ResponseBean executeUpdateUserByUserForAdmin(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.executeUpdateUserByUserForAdmin(request) == true) {
			response.setCode("OK");
			response.setMessage("Se actualizo correctamente");
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo actualizar correctamente");
		}
		return response;
	}

	@Override
	public ResponseBean removeUserByUser(String user) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.removeUserByUser(user)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
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
			response.setMessage("Lista de roles exitosa");
			response.setRoles(roles);
		}else {
			response.setCode("BAD00");
			response.setMessage("No se pudieron obtener los roles");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveUserRole(RequestBean request) {
		ResponseBean response = new ResponseBean();
		UserBean ub = userRoleDao.searchUserByUser(request.getUserPkFk());
		if(ub != null) {
			if(userRoleDao.executeSaveUserRole(request) == true) {
				response.setCode("OK");
				response.setMessage("Se asigno el rol correctamente");
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo asignar el rol");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El usuario no existe");
		}
		return response;
	}

	@Override
	public ResponseBean executeUpdateUserRoleByRoleAndUser(RequestBean request) {
		ResponseBean response = new ResponseBean();
		UserBean ub = userRoleDao.searchUserByUser(request.getUserPkFk());
		if(ub != null) {
			if(userRoleDao.executeUpdateUserRoleByRoleAndUser(request) == true) {
				response.setCode("OK");
				response.setMessage("Se actualizo el rol correctamente");
			}else{
				response.setCode("BAD00");
				response.setMessage("No se pudo actualizar el rol");
			}
		}else {
			response.setCode("BAD01");
			response.setMessage("El usuario no existe");
		}
		return response;
	}

	@Override
	public ResponseBean removeUserRoleByRoleAndUser(RequestBean request) {
		ResponseBean response = new ResponseBean();
		if(userRoleDao.removeUserRoleByRoleAndUser(request)) {
			response.setCode("OK");
			response.setMessage("Se elimino correctamente");
			
		}else{
			response.setCode("BAD00");
			response.setMessage("No se pudo eliminar correctamente");
		}
        return response;
	}

}
