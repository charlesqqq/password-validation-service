package com.test;


import com.test.service.PasswordValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ConfigurationProperties(prefix = "password")
public class PasswordValidationServiceTest {
	
	@Autowired
	private PasswordValidationService passwordValidationService;
	private String charactersErrorMessage;
	private String lengthErrorMessage;
	private String sequenceErrorMessage;
	
	@Test
	public void testPassword() {
		Set<String> errorMessages = passwordValidationService.validate("abc123XYZ");
		assertTrue(errorMessages.contains(charactersErrorMessage));
		
		errorMessages = passwordValidationService.validate("ab12");
		assertTrue(errorMessages.contains(lengthErrorMessage));
		
		errorMessages = passwordValidationService.validate("abcabc123");
		assertTrue(errorMessages.contains(sequenceErrorMessage));
		
		errorMessages = passwordValidationService.validate("abc123456789XYZ");
		assertTrue(errorMessages.contains(charactersErrorMessage));
		assertTrue(errorMessages.contains(lengthErrorMessage));
		
		errorMessages = passwordValidationService.validate("ABcc123456");
		assertTrue(errorMessages.contains(charactersErrorMessage));
		assertTrue(errorMessages.contains(sequenceErrorMessage));
		
		errorMessages = passwordValidationService.validate("abcabc123456789");
		assertTrue(errorMessages.contains(lengthErrorMessage));
		assertTrue(errorMessages.contains(sequenceErrorMessage));
		
		errorMessages = passwordValidationService.validate("abcabc123456789XYZ");
		assertTrue(errorMessages.contains(charactersErrorMessage));
		assertTrue(errorMessages.contains(lengthErrorMessage));
		assertTrue(errorMessages.contains(sequenceErrorMessage));
		
		errorMessages = passwordValidationService.validate("abc123456");
		assertTrue(errorMessages.isEmpty());
	}
	
	public void setCharactersErrorMessage(String charactersErrorMessage) {
		this.charactersErrorMessage = charactersErrorMessage;
	}
	
	public void setLengthErrorMessage(String lengthErrorMessage) {
		this.lengthErrorMessage = lengthErrorMessage;
	}
	
	public void setSequenceErrorMessage(String sequenceErrorMessage) {
		this.sequenceErrorMessage = sequenceErrorMessage;
	}
	
}
