package com.boot.ui.api.client.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.boot.ui.api.client.support.SupportApiClient;
import com.boot.ui.model.TokenModel;

import reactor.core.publisher.Mono;

@Component
public class AuthClient extends SupportApiClient{

	@Value("${resource.jwt.server}")
	private String url;
	public Mono<TokenModel> getToken(String uri,MultiValueMap<String,Object>param){
		String requestURL = this.url + uri;
		Mono<TokenModel> result = (Mono<TokenModel>)post(requestURL,param,TokenModel.class);
		return result;
	}		
}
