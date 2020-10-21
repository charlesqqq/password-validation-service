package com.test;

import com.test.rule.PasswordRule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests subclass of {@link PasswordRule}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class PasswordRuleTest {
	
	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	PasswordTestData passwordTestData;
	List<String> invalidPasswords;
	String expectedErrorMessage;
	PasswordRule passwordRule;
	private List<String> validPasswords;
	
	@Before
	public void prepareValidPasswords() {
		validPasswords = passwordTestData.getValidPasswords();
	}
	
	/**
	 * Tests password rule.
	 * {@link #passwordRule}, {@link #invalidPasswords} and {@link #expectedErrorMessage} are initialized by subclass.
	 */
	@Test
	public void testPasswordRule() {
		validPasswords.forEach(password -> assertTrue(passwordRule.isValid(password)));
		invalidPasswords.forEach(password -> assertFalse(passwordRule.isValid(password)));
		assertEquals(passwordRule.getErrorMessage(), expectedErrorMessage);
	}
	
}
