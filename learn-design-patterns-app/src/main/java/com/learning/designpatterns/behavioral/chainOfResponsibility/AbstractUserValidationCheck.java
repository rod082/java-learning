package com.learning.designpatterns.behavioral.chainOfResponsibility;

public abstract class AbstractUserValidationCheck implements UserValidationCheck {

	private UserValidationCheck nextValidationCheck;
	
	
	public void setNextValidationCheck(UserValidationCheck nextValidationCheck) {
		this.nextValidationCheck = nextValidationCheck;
	}
	
	public UserValidationCheck getNextValidationCheck() {
		return nextValidationCheck;
	}
}
