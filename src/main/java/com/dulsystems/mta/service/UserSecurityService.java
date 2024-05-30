package com.dulsystems.mta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.dao.UserDao;
import com.dulsystems.mta.exception.BusinessException;

@Service
public class UserSecurityService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String user) throws /*UsernameNotFoundException*/ BusinessException {
		System.out.println(user);
		UserBean ub = userDao.searchUserByUsername(user);
		if(ub == null) {
			//throw new UsernameNotFoundException("User Not Found");
			throw new BusinessException("E-404",HttpStatus.NOT_FOUND,"El usuario no existe, rectificalo");
		}
		
		String[] roles = userDao.searchUserRolesByUsername(user).stream().map(UserBean::getRoleUser).toArray(String[]::new);
		
		return User.builder()
					.username(ub.getUserPk())
					.password(ub.getUserPassword())
					.authorities(grantedAuthorities(roles))
					.accountLocked(ub.getUserLocked())
					.disabled(ub.getUserDisabled())
					.build();
	}
	
	private String[] getAuthorities(String role) {
		if(/*"ADMIN".equals(role) || */"EMPLOYEE".equals(role)) {
			return new String[] {"search_vehicles_by_plate"};
		}
		return new String[] {};
		
	}
	
	private List<GrantedAuthority> grantedAuthorities(String[] roles){
		List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
		
		for(String role: roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
			
			for(String authority: getAuthorities(role)) {
				authorities.add(new SimpleGrantedAuthority(authority));
			}
		}
		return authorities;
		
	}

}
