package com.test.rule;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "password-rule.characters")
public class PasswordCharactersRule extends PasswordRule {
	
	/**
	 * Checks if password contains lowercase letters and numerical digits only, with at least one of each.
	 *
	 * @param password password to be validated.
	 * @return true if password is valid.
	 */
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
	
}
