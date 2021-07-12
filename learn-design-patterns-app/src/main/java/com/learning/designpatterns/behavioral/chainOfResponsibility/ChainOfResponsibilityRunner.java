package com.learning.designpatterns.behavioral.chainOfResponsibility;

public class ChainOfResponsibilityRunner {

	public static void main(String[] args) {
		System.out.println("-------------------- PASSED TEST --------------------");
		passTest();
		System.out.println("-------------------- FAILED TEST --------------------");
		failedTest();
	}

	static void passTest() {
		UserInputData userData = new UserInputData("r2@gmail.com", "pass1");
		UserValidationCheckChain userValidationCheckChain = new UserValidationCheckChain();
		try {
			userValidationCheckChain.doCheck(userData);
		} catch (UserValidationCheckException e) {
			e.printStackTrace();
		}
	}
	
	static void failedTest() {
		UserInputData userData = new UserInputData("my-email@gmail.com", "pass2");
		UserValidationCheckChain userValidationCheckChain = new UserValidationCheckChain();
		try {
			userValidationCheckChain.doCheck(userData);
		} catch (UserValidationCheckException e) {
			e.printStackTrace();
		}
	}
}
