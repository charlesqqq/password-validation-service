package com.test;

import com.test.rule.PasswordSequenceRule;
import org.junit.Before;

/**
 * Tests {@link PasswordSequenceRule}.
 */
public class PasswordSequenceTest extends PasswordRuleTest {
	
	@Before
	public void prepareData() {
		invalidPasswords = passwordTestData.getInvalidSequencePasswords();
		expectedErrorMessage = passwordTestData.getSequenceErrorMessage();
		passwordRule = applicationContext.getBean(PasswordSequenceRule.class);
	}
	
}
