package com.test.rule;

import org.springframework.stereotype.Component;

@Component
public class PasswordLengthRule implements PasswordRule {
	
	private int minimumLength;
	private int maximumLength;
	private String lengthErrorMessage;
	
	@Override
	public boolean isValid(String password) {
		int length = password.length();
		return length >= minimumLength && length <= maximumLength;
	}
	
	@Override
	public String getErrorMessage() {
		return lengthErrorMessage;
	}
	
	public void setMinimumLength(int minimumLength) {
		this.minimumLength = minimumLength;
	}
	
	public void setMaximumLength(int maximumLength) {
		this.maximumLength = maximumLength;
	}
	
	public void setLengthErrorMessage(String lengthErrorMessage) {
		this.lengthErrorMessage = lengthErrorMessage;
	}
	
}
