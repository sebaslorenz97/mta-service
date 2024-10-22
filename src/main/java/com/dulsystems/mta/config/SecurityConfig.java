package com.dulsystems.mta.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	private final JwtFilter jwtFilter;
	private final CorsConfigurationSource corsConfigurationSource;
	
	@Autowired
	public SecurityConfig(CorsConfigurationSource corsConfigurationSource, JwtFilter jwtFilter) {
		this.corsConfigurationSource = corsConfigurationSource;
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		logger.info("The user enter to filterChain method");
		
		http
			.csrf(AbstractHttpConfigurer::disable)
			.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(this.corsConfigurationSource))
			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> {
				auth
					.requestMatchers("/mi-taller-automotriz/test-controller/gettestdata").permitAll()
					.requestMatchers("/mi-taller-automotriz/test-controller/posttestdata").permitAll()
					.requestMatchers("/mi-taller-automotriz/auth/login").permitAll()
					.requestMatchers(new AntPathRequestMatcher("/error")).permitAll()
					.requestMatchers("/mi-taller-automotriz/user-and-roles/**").hasRole("ADMIN")
					.requestMatchers("/mi-taller-automotriz/manager-account-owner/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
					.requestMatchers("/mi-taller-automotriz/address-catalogs/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
					.requestMatchers("/mi-taller-automotriz/customer/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
					.requestMatchers("/mi-taller-automotriz/vehicle-catalogs/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
					.requestMatchers("/mi-taller-automotriz/vehicle/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
					.requestMatchers("/mi-taller-automotriz/quote-and-details/**").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
					.anyRequest()
					.authenticated();
			})
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
		
	}
	
	/*@Bean
	public UserDetailsService memoryUser() {
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		UserDetails employee = User.builder()
				.username("employee")
				.password(passwordEncoder().encode("employee"))
				.roles("EMPLOYEE")
				.build();
		
		return new InMemoryUserDetailsManager(admin, employee);
		
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
}
