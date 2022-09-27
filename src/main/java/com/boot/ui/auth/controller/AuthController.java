package com.boot.ui.auth.controller;

import org.json.simple.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ui.api.client.AuthClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/api")
public class AuthController {
	
	private final AuthClient authClient;
	public AuthController(AuthClient authClient) {
		this.authClient = authClient;
	}
	
	@PostMapping(value = "/token",consumes = "application/json")	
	public String token(@RequestBody String id,@RequestBody String pw) {
		System.out.println("ID = "+id + " , " + pw);
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
		param.add("id", id);
		param.add("pw", pw);
		Mono<JSONObject> result = authClient.getToken("/api/token", param);
		
		return "token";
	}
}
