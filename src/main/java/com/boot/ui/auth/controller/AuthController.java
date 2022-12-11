package com.boot.ui.auth.controller;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ui.api.client.auth.AuthClient;
import com.boot.ui.model.TokenModel;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/call")
public class AuthController {
	
	private final AuthClient authClient;
	public AuthController(AuthClient authClient) {
		this.authClient = authClient;
	}
	
	@PostMapping(value = "/token",consumes = "application/json")	
	public Mono<TokenModel> token() {		
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		param.add("id", "client");
		param.add("pw", "1234");
		Mono<TokenModel> result = authClient.getToken("/api/token", param);
		
		return result;
	}
}
