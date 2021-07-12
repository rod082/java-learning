package com.learning.designpatterns.behavioral.chainOfResponsibility;

public class UserInputsValidationCheck extends AbstractUserValidationCheck {

	public boolean doCheck(UserInputData userData) throws UserValidationCheckException {
		if (userData == null) {
			throw new UserValidationCheckException("UserData object connet be null!");
		}

		if (isValidEmail(userData.getEmail()) && isValidPass(userData.getPassword())) {
			System.out.println("UserInputsValidationCheck Passed!");
			return getNextValidationCheck().doCheck(userData);
		}

		throw new UserValidationCheckException("UserInputsValidationCheck failed! invalid email or passord");
	}

	private boolean isValidEmail(String email) {
		return email != null && !email.isEmpty();
	}

	private boolean isValidPass(String pass) {
		return pass != null && !pass.isEmpty();
	}
}
