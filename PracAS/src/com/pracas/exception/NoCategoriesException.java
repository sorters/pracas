package com.pracas.exception;

public class NoCategoriesException extends Exception {

	public NoCategoriesException() {
		super();
	}
	
	public NoCategoriesException(String message) {
		super(message);
	}

	public NoCategoriesException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NoCategoriesException(Throwable cause) {
		super(cause);
	}
	
}
