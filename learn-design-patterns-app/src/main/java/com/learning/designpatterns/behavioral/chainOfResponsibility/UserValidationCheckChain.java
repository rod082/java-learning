package com.learning.designpatterns.behavioral.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class UserValidationCheckChain {

	private List<UserValidationCheck> validationChecks = new ArrayList<>();

	private UserValidationCheck firstUserValidationCheck;

	public UserValidationCheckChain() {
		init();
	}

	private void init() {
		UserInputsValidationCheck userInputsValidationCheck = new UserInputsValidationCheck();
		UserRegistrationCheck userRegistrationCheck = new UserRegistrationCheck();
		userInputsValidationCheck.setNextValidationCheck(userRegistrationCheck);

		firstUserValidationCheck = userInputsValidationCheck;

		validationChecks.add(userInputsValidationCheck);
		validationChecks.add(userRegistrationCheck);
	}

	boolean doCheck(UserInputData userData) throws UserValidationCheckException {
		return firstUserValidationCheck.doCheck(userData);

		// UserValidationCheck currUserValidationCheck = firstUserValidationCheck;
		// while(currUserValidationCheck!=null) {
		// currUserValidationCheck.doCheck(userData);
		// }
	}

}
