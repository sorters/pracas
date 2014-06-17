package com.pracas.exceptions;

public class UsernameNotExistsException extends Exception {

	public UsernameNotExistsException() {
		super();
	}
	
	public UsernameNotExistsException(String message) {
		super(message);
	}

	public UsernameNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UsernameNotExistsException(Throwable cause) {
		super(cause);
	}
	
}
