package com.test;

import com.test.rule.PasswordSequenceRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordSequenceTest {
	
	@Autowired
	private PasswordSequenceRule passwordSequenceRule;
	@Value("${password.sequenceErrorMessage}")
	private String errorMessage;
	
	@Test
	public void testSequence() {
		assertFalse(passwordSequenceRule.isValid("abcabc123"));
		assertFalse(passwordSequenceRule.isValid("abc1212cd"));
		assertFalse(passwordSequenceRule.isValid("abcdd123"));
		assertTrue(passwordSequenceRule.isValid("abc123abc"));
		assertEquals(passwordSequenceRule.getErrorMessage(), errorMessage);
	}
	
}
