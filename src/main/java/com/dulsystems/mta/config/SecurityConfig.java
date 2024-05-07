package com.dulsystems.mta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig {
	
	CorsConfigurationSource corsConfigurationSource;
	
	public SecurityConfig(CorsConfigurationSource corsConfigurationSource) {
		this.corsConfigurationSource = corsConfigurationSource;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
				.csrf(csrf -> csrf.disable())
				.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource))
				.authorizeHttpRequests(auth -> {
					try {
						auth
							.requestMatchers(HttpMethod.GET, "/mi-taller-automotriz/quote/**").hasAnyRole("ADMIN","EMPLOYEE")
							.requestMatchers(HttpMethod.GET, "/mi-taller-automotriz/customer/**").hasAnyRole("ADMIN","EMPLOYEE")
							.requestMatchers(HttpMethod.GET, "/mi-taller-automotriz/quote-detail/**").hasAnyRole("ADMIN","EMPLOYEE")
							.requestMatchers(HttpMethod.GET,"/mi-taller-automotriz/vehicle/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/mi-taller-automotriz/vehicle-line/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/mi-taller-automotriz/vehicle-year/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/mi-taller-automotriz/vehicle-model/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/mi-taller-automotriz/state/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/mi-taller-automotriz/municipality/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST).hasRole("ADMIN")
							.requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
							.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
							.anyRequest()
							.authenticated();
					} catch (Exception e) {
						e.printStackTrace();
					}
				})
				.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	
	@Bean
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
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	
}
