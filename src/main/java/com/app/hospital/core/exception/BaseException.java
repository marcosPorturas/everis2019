package com.app.hospital.core.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BaseException extends Exception{

	private static final long serialVersionUID = 1L;

	private final String code;
	private final String messageDeveloper;
	private final HttpStatus status;

	public BaseException() {
		this.code = "";
		this.messageDeveloper = "";
		this.status = null;
	}
	
	public BaseException(String code, String message, Exception exception) {
		super(message,exception);
		this.code=code;
		this.messageDeveloper="";
		this.status=null;
	}

}
