package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.controller.PasswordValidationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests {@link PasswordValidationController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PasswordValidationControllerTest {
	
	private static String QUERY_STRING = "?password=";
	@Autowired
	private PasswordTestData passwordTestData;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testController() throws Exception {
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
	private void validate(List<String> passwords, String... expectedErrorMessages) throws Exception {
		for (String password : passwords) {
			String content = mockMvc.perform(get(passwordTestData.getValidatePasswordURL() + QUERY_STRING + password))
					.andExpect(status().isOk())
					.andReturn().getResponse().getContentAsString();
			Set<String> errorMessages = objectMapper.readValue(content, Set.class);
			if (expectedErrorMessages.length == 0) {
				assertTrue(errorMessages.isEmpty());
			} else {
				assertTrue(errorMessages.containsAll(Arrays.asList(expectedErrorMessages)));
			}
		}
	}
	
}
