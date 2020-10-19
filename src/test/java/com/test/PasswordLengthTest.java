package com.test;

import com.test.rule.PasswordLengthRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordLengthTest {
	
	@Autowired
	private PasswordLengthRule passwordLengthRule;
	@Value("${password.lengthErrorMessage}")
	private String errorMessage;
	
	@Test
	public void testLength() {
		assertFalse(passwordLengthRule.isValid("abc1"));
		assertFalse(passwordLengthRule.isValid("abc0123456789"));
		assertTrue(passwordLengthRule.isValid("abc123"));
		assertEquals(passwordLengthRule.getErrorMessage(), errorMessage);
	}
	
}
