package com.test.rule;

public abstract class PasswordRule {
	
	private String errorMessage;
	
	public abstract boolean isValid(String password);
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
