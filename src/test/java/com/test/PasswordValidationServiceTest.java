package com.test;


import com.test.service.PasswordValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Tests {@link PasswordValidationService}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordValidationServiceTest {
	
	@Autowired
	private PasswordValidationService passwordValidationService;
	@Autowired
	private PasswordTestData passwordTestData;
	
	@Test
	public void testService() {
		String charactersErrorMessage = passwordTestData.getCharactersErrorMessage();
		String lengthErrorMessage = passwordTestData.getLengthErrorMessage();
		String sequenceErrorMessage = passwordTestData.getSequenceErrorMessage();
		validate(passwordTestData.getInvalidCharactersPasswords(), charactersErrorMessage);
		validate(passwordTestData.getInvalidLengthPasswords(), lengthErrorMessage);
		validate(passwordTestData.getInvalidSequencePasswords(), sequenceErrorMessage);
		validate(passwordTestData.getAllInvalidPasswords(), charactersErrorMessage, lengthErrorMessage, sequenceErrorMessage);
		validate(passwordTestData.getValidPasswords());
	}
	
	/**
	 * Validates passwords and checks if the error messages are as expected.
	 *
	 * @param passwords passwords to be validated.
	 * @param expectedErrorMessages expected error messages.
	 */
	private void validate(List<String> passwords, String... expectedErrorMessages) {
		passwords.forEach(password -> {
			Set<String> errorMessages = passwordValidationService.validate(password);
			if (expectedErrorMessages.length == 0) {
				assertTrue(errorMessages.isEmpty());
			} else {
				assertTrue(errorMessages.containsAll(Arrays.asList(expectedErrorMessages)));
			}
		});
	}
	
}
