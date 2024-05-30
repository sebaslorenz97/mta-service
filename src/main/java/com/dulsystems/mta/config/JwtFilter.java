package com.dulsystems.mta.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dulsystems.mta.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	private final JwtUtil jwtUtil;
	private final UserDetailsService userDetailsService;
	
	@Autowired
	public JwtFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
									FilterChain filterChain) throws ServletException, IOException {
		//STEPS FOR VALIDATE A JSON WEB TOKEN
		//1.- Validate that it is a valid authorization header
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			System.out.println("---------> HEADER NO VALIDO" + "Header: " + authHeader);
			return;
		}
		
		//2.- Validate that the JWT is valid
		String jwt = authHeader.split(" ")[1].trim();
		if(!jwtUtil.isValid(jwt)) {
			filterChain.doFilter(request, response);
			System.out.println("---------> JWT NO VALIDO");
			return;
		}
		
		//3.- Load user from UserDetailSservice
		String user = jwtUtil.getUser(jwt);
		User userr = (User) userDetailsService.loadUserByUsername(user);
		System.out.println("---------> USUARIO CARGADO DESDE EL DETAIL SERVICE");
		
		//4.- Load user in security context
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userr.getUsername(), userr.getPassword(), userr.getAuthorities()
		);
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		System.out.println("USUARIO CARGADO EN EL CONTEXTO DE SEGURIDAD");
		System.out.println(authenticationToken);
		filterChain.doFilter(request, response);
	}

}
