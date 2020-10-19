package com.test;

import com.test.rule.PasswordCharactersRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordCharactersTest {
	
	@Autowired
	private PasswordCharactersRule passwordCharactersRule;
	@Value("${password.charactersErrorMessage}")
	private String errorMessage;
	
	@Test
	public void testCharacters() {
		assertFalse(passwordCharactersRule.isValid("aBc123"));
		assertFalse(passwordCharactersRule.isValid("abc_123"));
		assertTrue(passwordCharactersRule.isValid("abc123"));
		assertEquals(passwordCharactersRule.getErrorMessage(), errorMessage);
	}
	
}
