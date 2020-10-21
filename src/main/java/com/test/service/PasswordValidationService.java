package com.test.service;

import com.test.rule.PasswordRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PasswordValidationService {
	
	@Autowired
	private Set<PasswordRule> passwordRules;
	
	/**
	 * Validate password with {@link #passwordRules}.
	 *
	 * @param password password to be validated.
	 * @return error messages or empty if password is valid.
	 */
	public Set<String> validate(String password) {
		Set<String> errorMessages = new HashSet<>();
		
		for (PasswordRule rule : passwordRules) {
			if (!rule.isValid(password)) {
				errorMessages.add(rule.getErrorMessage());
			}
		}
		
		return errorMessages;
	}
	
}
