package com.dulsystems.mta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	
	@Autowired
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseBean> login(@RequestBody RequestBean rb){
		HttpHeaders httpHeaders = new HttpHeaders();
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(rb.getUserPk(), rb.getUserPassword());

		Authentication authentication = authenticationManager.authenticate(login);
		
		System.out.println(authentication.isAuthenticated());
		System.out.println(authentication.getPrincipal());
		
		String jwt = jwtUtil.create(rb.getUserPk());
		
		httpHeaders.add(HttpHeaders.AUTHORIZATION, jwt);
		
		List<String> customHeaders = new ArrayList<String>();
		customHeaders.add("Authorization");
		httpHeaders.setAccessControlExposeHeaders(customHeaders);
		
		return ResponseEntity.ok().headers(httpHeaders).build();
		
	}

}
