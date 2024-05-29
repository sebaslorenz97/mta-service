package com.dulsystems.mta.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorBean {

	private String code;
	private String message;
	private String level;
	private String description;
	private String moreInfo;
	
}
