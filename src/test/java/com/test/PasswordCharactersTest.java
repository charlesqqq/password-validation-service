package com.test;

import com.test.rule.PasswordCharactersRule;
import org.junit.Before;

/**
 * Tests {@link PasswordCharactersRule}.
 */
public class PasswordCharactersTest extends PasswordRuleTest {
	
	@Before
	public void prepareData() {
		invalidPasswords = passwordTestData.getInvalidCharactersPasswords();
		expectedErrorMessage = passwordTestData.getCharactersErrorMessage();
		passwordRule = applicationContext.getBean(PasswordCharactersRule.class);
	}
	
}
