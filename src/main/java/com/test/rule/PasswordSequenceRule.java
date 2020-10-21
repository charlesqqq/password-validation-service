package com.test.rule;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@ConfigurationProperties(prefix = "password-rule.sequence")
public class PasswordSequenceRule extends PasswordRule {
	
	private String regex;
	
	/**
	 * Checks if password does not match {@link #regex}.
	 *
	 * @param password password to be validated.
	 * @return true if password is valid.
	 */
	@Override
	public boolean isValid(String password) {
		return !Pattern.compile(regex).matcher(password).find();
	}
	
	public void setRegex(String regex) {
		this.regex = regex;
	}
	
}
