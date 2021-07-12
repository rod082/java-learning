package com.learning.designpatterns.behavioral.chainOfResponsibility;

public class UserValidationCheckException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserValidationCheckException(String error) {
		super(error);
	}
}
