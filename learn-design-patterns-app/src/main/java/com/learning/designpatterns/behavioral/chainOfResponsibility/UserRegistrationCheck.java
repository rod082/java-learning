package com.learning.designpatterns.behavioral.chainOfResponsibility;

import java.util.HashSet;
import java.util.Set;

public class UserRegistrationCheck extends AbstractUserValidationCheck {

	private Set<String> registernedEmailsLookup = new HashSet<String>();

	public UserRegistrationCheck() {
		init();
	}

	void init() {
		registernedEmailsLookup.add("r1@gmail.com");
		registernedEmailsLookup.add("r2@gmail.com");
	}

	public boolean doCheck(UserInputData userData) throws UserValidationCheckException {
		if (userData == null) {
			throw new UserValidationCheckException("UserData object connet be null!");
		}

		if (isEmailFound(userData.getEmail())) {
			System.out.println("UserRegistrationCheck Passed! , email found");
			return getNextValidationCheck() != null && getNextValidationCheck().doCheck(userData);
		}
		
		throw new UserValidationCheckException("UserRegistrationCheck failed! email is not registered, sign up first");
	}

	private boolean isEmailFound(String email) {
		return registernedEmailsLookup.contains(email);
	}

}
