package com.test.rule;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "password")
public interface PasswordRule {
	
	boolean isValid(String password);
	
	String getErrorMessage();
	
}
