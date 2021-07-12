package com.learning.designpatterns.behavioral.chainOfResponsibility;

public interface UserValidationCheck {

	UserValidationCheck getNextValidationCheck();

	boolean doCheck(UserInputData userData) throws UserValidationCheckException;
}
