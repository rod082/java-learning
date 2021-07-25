package com.learning.hibernate.shopping.model;

public enum UserRole {

	ADMIN(1, "Admin"), OPERATOR(2, "Operator"), SUPPLIER(3, "Supplier");

	private int code;
	private String value;

	private UserRole(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public String value() {
		return value;
	}

	public int code() {
		return code;
	}

	public static UserRole valueOf(int code) {
		switch (code) {
		case 1:
			return ADMIN;
		case 2:
			return OPERATOR;
		case 3:
			return SUPPLIER;
		default:
			return null;
		}
	}

}
