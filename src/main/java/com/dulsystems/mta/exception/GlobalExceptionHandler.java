package com.dulsystems.mta.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dulsystems.mta.bean.ErrorBean;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ErrorBean> businessExceptionHandler(BusinessException bex){
		ErrorBean errorBean = ErrorBean.builder().code(bex.getCode()).message(bex.getMessage()).build();
		return new ResponseEntity<>(errorBean, bex.getStatus());
	}

}
