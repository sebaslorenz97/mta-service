package com.dulsystems.mta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulsystems.mta.bean.UserBean;
import com.dulsystems.mta.util.JwtUtil;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mi-taller-automotriz/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody UserBean ub){
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(ub.getUserName(), ub.getUserPassword());
		
		Authentication authentication = authenticationManager.authenticate(login);
		System.out.println(authentication.isAuthenticated());
		System.out.println(authentication.getPrincipal());
		
		String jwt = jwtUtil.create(ub.getUserName());
		
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).build();
		
	}

}
