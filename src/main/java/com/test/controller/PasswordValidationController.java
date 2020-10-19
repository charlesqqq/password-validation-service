package com.test.controller;

import com.test.service.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PasswordValidationController {
	
	@Autowired
	private PasswordValidationService passwordValidationService;
	
	@GetMapping("/validatePassword")
	public Set<String> validatePassword(@RequestParam(defaultValue = "") String password) {
		return passwordValidationService.validate(password);
	}
	
}
