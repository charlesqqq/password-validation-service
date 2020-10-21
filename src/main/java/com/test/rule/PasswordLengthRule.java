package com.test.rule;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "password-rule.length")
public class PasswordLengthRule extends PasswordRule {
	
	private int minimum;
	private int maximum;
	
	/**
	 * Checks if password is between {@link #minimum} and {@link #maximum} characters in length.
	 *
	 * @param password password to be validated.
	 * @return true if password is valid.
	 */
	@Override
	public boolean isValid(String password) {
		int length = password.length();
		return length >= minimum && length <= maximum;
	}
	
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
}
