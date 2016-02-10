package com.tothenew.intellimeet.exception;

public class ObjectNotFoundException extends Exception {

	String message;

	public ObjectNotFoundException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
}
