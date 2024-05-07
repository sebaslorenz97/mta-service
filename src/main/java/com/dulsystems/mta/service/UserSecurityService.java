package com.dulsystems.mta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.dao.UserDao;

@Service
public class UserSecurityService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean ub = userDao.searchUserByUsername(username);
		if(ub == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return User.builder()
					.username(ub.getUserName())
					.password(ub.getUserPassword())
					.roles("ADMIN")
					.accountLocked(ub.getUserLocked())
					.disabled(ub.getUserDisabled())
					.build();
	}

}
