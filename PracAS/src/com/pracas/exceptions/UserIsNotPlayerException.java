package com.pracas.exceptions;

public class UserIsNotPlayerException extends Exception {

	public UserIsNotPlayerException() {
		super();
	}
	
	public UserIsNotPlayerException(String message) {
		super(message);
	}

	public UserIsNotPlayerException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserIsNotPlayerException(Throwable cause) {
		super(cause);
	}
	
}
