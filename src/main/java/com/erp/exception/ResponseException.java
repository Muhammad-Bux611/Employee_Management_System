package com.erp.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseException {
	
	String message;
	int status;

}
