package com.pracas.exception;

public class CategoryHasNoWordsException extends Exception {

	public CategoryHasNoWordsException() {
		super();
	}
	
	public CategoryHasNoWordsException(String message) {
		super(message);
	}

	public CategoryHasNoWordsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CategoryHasNoWordsException(Throwable cause) {
		super(cause);
	}
	
}
