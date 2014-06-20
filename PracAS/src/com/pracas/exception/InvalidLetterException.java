package com.pracas.exception;

public class InvalidLetterException extends Exception {

	public InvalidLetterException() {
		super();
	}
	
	public InvalidLetterException(String message) {
		super(message);
	}

	public InvalidLetterException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidLetterException(Throwable cause) {
		super(cause);
	}
	
}
