package com.ick.dbreader.util;

public class ConnException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ConnException() { }
	
	public ConnException(String message) {
		super(message);
	}
	
	public ConnException(String message, Throwable cause) {
		super(message, cause);
	}

}
