package com.test.rule;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordSequenceRule implements PasswordRule {
	
	private String sequenceRegex;
	private String sequenceErrorMessage;
	
	@Override
	public boolean isValid(String password) {
		return !Pattern.compile(sequenceRegex).matcher(password).find();
	}
	
	@Override
	public String getErrorMessage() {
		return sequenceErrorMessage;
	}
	
	public void setSequenceRegex(String sequenceRegex) {
		this.sequenceRegex = sequenceRegex;
	}
	
	public void setSequenceErrorMessage(String sequenceErrorMessage) {
		this.sequenceErrorMessage = sequenceErrorMessage;
	}
	
}
