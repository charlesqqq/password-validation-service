package com.test;

import com.test.rule.PasswordLengthRule;
import org.junit.Before;

/**
 * Tests {@link PasswordLengthRule}.
 */
public class PasswordLengthTest extends PasswordRuleTest {
	
	@Before
	public void prepareData() {
		passwordRule = applicationContext.getBean(PasswordLengthRule.class);
		invalidPasswords = passwordTestData.getInvalidLengthPasswords();
		expectedErrorMessage = passwordTestData.getLengthErrorMessage();
	}
	
}
