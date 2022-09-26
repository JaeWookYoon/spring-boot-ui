package com.boot.ui.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class AuthController {
	@PostMapping(value = "/token")	
	public String token() {
		return "token";
	}
}
