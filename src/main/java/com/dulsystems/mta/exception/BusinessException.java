package com.dulsystems.mta.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BusinessException extends RuntimeException{
	
	@Getter
	@Setter
	private String code;
	
	@Getter
	@Setter
	private HttpStatus status;
	
	public BusinessException(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}
	
}
