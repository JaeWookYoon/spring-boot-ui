package com.boot.ui.api.client;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.boot.ui.api.client.support.SupportApiClient;

import reactor.core.publisher.Mono;

@Component
public class AuthClient extends SupportApiClient{

	private String url;
	public Mono<JSONObject> getToken(String uri,MultiValueMap<String,Object>param){
		String requestURL = this.url + uri;
		Mono<JSONObject> result = (Mono<JSONObject>)post(requestURL,param,JSONObject.class);
		return result;
	}	
	@PostConstruct
	public void setUrl() {
		this.url = "http://localhost:8081";
	}
}
