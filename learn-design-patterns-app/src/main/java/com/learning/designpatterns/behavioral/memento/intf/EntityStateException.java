package com.learning.designpatterns.behavioral.memento.intf;

public class EntityStateException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityStateException() {
		super();
	}

	public EntityStateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityStateException(String message) {
		super(message);
	}

	public EntityStateException(Throwable cause) {
		super(cause);
	}

}
