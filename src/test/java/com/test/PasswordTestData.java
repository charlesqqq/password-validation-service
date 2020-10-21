package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Reads test data from application.yml.
 */
@Component
class PasswordTestData {
	
	@Value("${passwordTestData.invalid.characters}")
	private List<String> invalidCharactersPasswords;
	@Value("${passwordTestData.invalid.length}")
	private List<String> invalidLengthPasswords;
	@Value("${passwordTestData.invalid.sequence}")
	private List<String> invalidSequencePasswords;
	@Value("${passwordTestData.valid}")
	private List<String> validPasswords;
	@Value("${passwordTestData.invalid.all}")
	private List<String> allInvalidPasswords;
	@Value("${passwordRule.characters.errorMessage}")
	private String charactersErrorMessage;
	@Value("${passwordRule.length.errorMessage}")
	private String lengthErrorMessage;
	@Value("${passwordRule.sequence.errorMessage}")
	private String sequenceErrorMessage;
	@Value("${validatePasswordURL}")
	private String validatePasswordURL;
	
	public List<String> getInvalidCharactersPasswords() {
		return invalidCharactersPasswords;
	}
	
	public List<String> getInvalidLengthPasswords() {
		return invalidLengthPasswords;
	}
	
	public List<String> getInvalidSequencePasswords() {
		return invalidSequencePasswords;
	}
	
	public List<String> getValidPasswords() {
		return validPasswords;
	}
	
	public List<String> getAllInvalidPasswords() {
		return allInvalidPasswords;
	}
	
	public String getCharactersErrorMessage() {
		return charactersErrorMessage;
	}
	
	public String getLengthErrorMessage() {
		return lengthErrorMessage;
	}
	
	public String getSequenceErrorMessage() {
		return sequenceErrorMessage;
	}
	
	public String getValidatePasswordURL() {
		return validatePasswordURL;
	}
	
}
