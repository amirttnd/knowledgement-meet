package com.tothenew.intellimeet.exception;

public class ObjectNotSavedException extends Throwable {
	String message;

	public ObjectNotSavedException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}
}
