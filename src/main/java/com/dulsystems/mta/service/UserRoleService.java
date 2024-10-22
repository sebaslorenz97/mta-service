package com.dulsystems.mta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.dao.UserRoleDao;
import com.dulsystems.mta.dao.mapper.UserMapper;
import com.dulsystems.mta.exception.BusinessException;
import com.dulsystems.mta.util.JwtUtil;
import com.dulsystems.mta.util.Queries;

@Service
public class UserRoleService implements IUserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserRoleService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	//METHODS FOR USER
	@Override
	public ResponseBean searchUserByUserOrMecId(String user, Integer userMecId) {
		ResponseBean response = new ResponseBean();
		Authentication authentication = null;
		if(user != null && user.equals("search-by-username")) {
			authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
			    user = authentication.getName();
			}
		}
		
		//SEARCH USER INFO
		UserBean ub = new UserBean();
		ub = userRoleDao.searchUserByUserOrMecId(user, userMecId);
		if(ub != null) {
			ub.setUserPassword(""); //THIS ENDPOINT MUST NOT RETURN THE PASSWORD SO WE REMOVE IT HERE
			response.setCode("OK");
			response.setMessage("Consulta realizada");
			response.setUb(ub);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el usuario");
		}
		if(user == null) {
			user = ub.getUserPk();
		}
		
		//SEARCH USER ROLES
		List<String> roles = userRoleDao.searchUserRolesByUserMethodTwo(user);
		if(roles.size() > 0) {
			response.setCode("OK");
			response.setMessage("Consulta exitosa");
			response.setRoles(roles);
		}else {
			//throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"El usuario no tiene roles asignados aun");
		}
		
		return response;
	}
	
	@Override
	public ResponseBean executeSaveUser(RequestBean request) {
		ResponseBean response = new ResponseBean();
		UserBean ub = userRoleDao.searchUserByUserOrMecId(request.getUserPk(), null);
		if(ub == null) {
			if(userRoleDao.executeSaveUser(request) == true) {
				response.setCode("OK");
				response.setMessage("Se guardo el registro");
				response.setUb(userRoleDao.searchUserByUserOrMecId(request.getUserPk(), null));
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
		if(userRoleDao.searchUserByUserOrMecId(request.getUserPk(), null)!=null) {
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
	public ResponseBean executeUpdatePasswordForAccountOwner(RequestBean request) {
		String currentUserName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		UserBean ub = userRoleDao.searchUserByUserOrMecId(currentUserName, null);
		ResponseBean response = new ResponseBean();
		if(bCryptPasswordEncoder.matches(request.getMyCurrentUserPassword(), ub.getUserPassword())) {
			request.setMyUserPassword(bCryptPasswordEncoder.encode(request.getMyUserPassword()));
			if(userRoleDao.executeUpdatePasswordForAccountOwner(request, currentUserName) == true) {
				response.setCode("OK");
				response.setMessage("Se actualizo el password correctamente");
			}else{
				throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el password");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se puede actualizar - Contraseña Invalida");
		}
		return response;
	}
	
	@Override
	public ResponseBean executeUpdateEmailForAccountOwner(RequestBean request) {
		String currentUserName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		ResponseBean response = new ResponseBean();
		
		if(userRoleDao.executeUpdateEmailForAccountOwner(request, currentUserName) == true) {
			response.setCode("OK");
			response.setMessage("Se actualizo el correo correctamente");
		}else{
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el correo");
		}
		
		return response;
	}

	@Override
	public ResponseBean removeUserByUser(String user) {
		ResponseBean response = new ResponseBean();
		
		//STEP 1: Remove all the user's roles to avoid issues because the user roles table depends of users table
		RequestBean request = new RequestBean();
		request.setAdminRole(false);
		request.setManagerRole(false);
		request.setEmployeeRole(false);
		request.setUserPkFk(user);
		executeSaveUserRoles(request);
		
		//STEP 2: Remove the user
		if(!user.equals("fernandoOrtega90")) {
			if(userRoleDao.searchUserByUserOrMecId(user, null)!=null) {
				if(userRoleDao.removeUserByUser(user)) {
					response.setCode("OK");
					response.setMessage("Se elimino el registro");
					
				}else{
					throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
				}
			}else {
				throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el usuario no existe");
			}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Este usuario es principal no se puede eliminar");
		}
        return response;
	}
	
	//METHODS FOR USER ROLES
	@Override
	public ResponseBean searchUserRolesByUser(String user) {
		ResponseBean response = new ResponseBean();
		List<String> roles = userRoleDao.searchUserRolesByUserMethodTwo(user);
		if(roles.size() > 0) {
			response.setCode("OK");
			response.setMessage("Consulta exitosa");
			response.setRoles(roles);
		}else {
			throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"El usuario no tiene roles asignados aun");
		}
		return response;
	}

	@Override
	public ResponseBean executeSaveUserRoles(RequestBean request) {
		String currentUserName = "";
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		}
		System.out.println("USUARIO EN SESION: "+ currentUserName);
	    
		ResponseBean response = new ResponseBean();
		StringBuilder sb = new StringBuilder();
		List<String> roles = new ArrayList<>();
		roles.add("ADMIN");
		roles.add("EMPLOYEE");
		roles.add("MANAGER");
		if(userRoleDao.searchUserByUserOrMecId(request.getUserPkFk(),null) != null) {
			//for(int i = 0; i < 3; i++) {
				if(request.getAdminRole() == true) {
					if(userRoleDao.searchUserRoleByRoleAndUserMethodTwo(roles.get(0),request)==null) {
						if(userRoleDao.executeSaveUserRole(roles.get(0),request) == true) {
							sb.append("Se asgino el rol: " + roles.get(0) + ". ");
						}else{
							sb.append("No se pudo asignar el rol "+ roles.get(0) +" al usuario");
						}
					}
				}else {
					if(!request.getUserPkFk().equals("fernandoOrtega90")) {
						if(userRoleDao.searchUserRoleByRoleAndUserMethodTwo(roles.get(0),request)!=null) {
							if(userRoleDao.removeUserRoleByRoleAndUser(roles.get(0),request) == true) {
								sb.append("Se desasigno el rol: " + roles.get(0) + ". ");
							}else{
								sb.append("No se pudo desasignar el rol "+ roles.get(0) +" al usuario");
							}
						}
					}else {
						throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se puede desasignar el rol ADMIN del usuario principal");
					}
				}
				if(request.getEmployeeRole() == true) {
					if(userRoleDao.searchUserRoleByRoleAndUserMethodTwo(roles.get(1),request)==null) {
						if(userRoleDao.executeSaveUserRole(roles.get(1),request) == true) {
							sb.append("Se asgino el rol: " + roles.get(1) + ". ");
						}else{
							sb.append("No se pudo asignar el rol "+ roles.get(1) +" al usuario");
						}
					}
				}else {
					if(userRoleDao.searchUserRoleByRoleAndUserMethodTwo(roles.get(1),request)!=null) {
						if(userRoleDao.removeUserRoleByRoleAndUser(roles.get(1),request) == true) {
							sb.append("Se desasigno el rol: " + roles.get(1) + ". ");
						}else{
							sb.append("No se pudo desasignar el rol "+ roles.get(1) +" al usuario");
						}
					}
				}
				if(request.getManagerRole() == true) {
					if(userRoleDao.searchUserRoleByRoleAndUserMethodTwo(roles.get(2),request)==null) {
						if(userRoleDao.executeSaveUserRole(roles.get(2),request) == true) {
							sb.append("Se asgino el rol: " + roles.get(2) + ". ");
						}else{
							sb.append("No se pudo asignar el rol "+ roles.get(2) +" al usuario");
						}
					}
				}else {
					if(userRoleDao.searchUserRoleByRoleAndUserMethodTwo(roles.get(2),request)!=null) {
						if(userRoleDao.removeUserRoleByRoleAndUser(roles.get(2),request) == true) {
							sb.append("Se desasigno el rol: " + roles.get(2) + ". ");
						}else{
							sb.append("No se pudo asignar el rol "+ roles.get(2) +" al usuario");
						}
					}
				}
				response.setCode("OK");
				response.setMessage("Operacion de asignacion de roles finalizada");
				response.setRoleAssignmentOperationResult(sb.toString());
			//}
		}else {
			throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el usuario");
		}
		return response;
	}

}
