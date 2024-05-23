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
		HttpHeaders httpHeaders = new HttpHeaders();
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(ub.getUserName(), ub.getUserPassword());
		
		System.out.println("ANTES DE AUTENTICAR!!!!!");
		Authentication authentication = authenticationManager.authenticate(login);
		System.out.println("DESPUES DE AUTENTICAR!!!!!");
		if(!authentication.isAuthenticated()) {
			System.out.println("NO SE PUDO AUTENTICAR!!!!");
			httpHeaders.add("message", "El usuario o contreseña no existe, rectificalos");
		}
		System.out.println(authentication.isAuthenticated());
		System.out.println(authentication.getPrincipal());
		
		String jwt = jwtUtil.create(ub.getUserName());
		httpHeaders.add(HttpHeaders.AUTHORIZATION, jwt);
		
		return ResponseEntity.ok().headers(httpHeaders).build();
		
	}

}
