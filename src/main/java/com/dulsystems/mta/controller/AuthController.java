package com.dulsystems.mta.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulsystems.mta.bean.RequestBean;
import com.dulsystems.mta.bean.ResponseBean;
import com.dulsystems.mta.util.JwtUtil;


@RestController
@RequestMapping("/mi-taller-automotriz/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseBean> login(@RequestBody RequestBean rb){
		logger.info("The user enter to login controller method");
		ResponseBean response = new ResponseBean();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		logger.info("-----------------------> 1");
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(rb.getUserPk(), rb.getUserPassword());
		logger.info("-----------------------> 2");

		Authentication authentication = authenticationManager.authenticate(login);
		logger.info("-----------------------> 3");
		/*List theList = new ArrayList(authentication.getAuthorities());
		response.setRolesFromAuthentication(theList);*/
		
		logger.info("{}",authentication.isAuthenticated());
		logger.info("{}",authentication.getPrincipal());
		
		List<String> roles = new ArrayList<String>();
		for(GrantedAuthority grantedAuthority: authentication.getAuthorities()) {
			roles.add(grantedAuthority.getAuthority());
		}
		response.setRoles(roles);
		
		String jwt = jwtUtil.create(rb.getUserPk());
		
		httpHeaders.add(HttpHeaders.AUTHORIZATION, jwt);
		
		List<String> customHeaders = new ArrayList<String>();
		customHeaders.add("Authorization");
		httpHeaders.setAccessControlExposeHeaders(customHeaders);
		
		//return ResponseEntity.ok().headers(httpHeaders).build();
		return new ResponseEntity<ResponseBean>(response,httpHeaders,HttpStatus.OK);
		
	}

}
