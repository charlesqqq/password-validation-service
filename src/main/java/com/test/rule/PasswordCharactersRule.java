package com.test.rule;

import org.springframework.stereotype.Component;

@Component
public class PasswordCharactersRule implements PasswordRule {
	
	private String charactersErrorMessage;
	
	@Override
	public boolean isValid(String password) {
		char[] chars = password.toCharArray();
		boolean hasLowercaseLetter = false;
		boolean hasDigit = false;
		
		for (char ch : chars) {
			if (Character.isLowerCase(ch)) {
				hasLowercaseLetter = true;
				continue;
			}
			if (Character.isDigit(ch)) {
				hasDigit = true;
				continue;
			}
			return false;
		}
		
		return hasLowercaseLetter && hasDigit;
	}
	
	@Override
	public String getErrorMessage() {
		return charactersErrorMessage;
	}
	
	public void setCharactersErrorMessage(String charactersErrorMessage) {
		this.charactersErrorMessage = charactersErrorMessage;
	}
	
}
