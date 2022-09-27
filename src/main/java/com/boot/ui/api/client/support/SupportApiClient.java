package com.boot.ui.api.client.support;

import java.util.Map;
import java.util.function.Consumer;

import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SupportApiClient {

	private WebClient webClient = null;
	//GET
	public Mono<?> get(String uri,MultiValueMap<String, String> param,Class<?> cast){
		webClient = WebClient.create();
		return webClient.get()
		  .uri(uriBuilder ->
		  	uriBuilder.path(uri)
			.queryParams(param).build()
		  )		  
		  .retrieve()
		  .bodyToMono(cast);		
	}
	
	public Flux<?> getList(String uri,MultiValueMap<String, String> param,Class<?> cast){
		webClient = WebClient.create();
		return webClient.get()
		  .uri(uriBuilder ->
		  	uriBuilder.path(uri)
			.queryParams(param).build()
		  )		  
		  .retrieve()
		  .bodyToFlux(cast.getClass());		
	}
	// POST
	public Mono<?> post(String uri,MultiValueMap<String, Object> param,Class<?> cast){
		webClient = WebClient.create();
		return webClient.post().
		  uri(uri)
		  .body(BodyInserters.fromMultipartData(param))
		  .retrieve()
		  .bodyToMono(cast.getClass());		
	}
	public Flux<?> postList(String uri,MultiValueMap<String, Object> param,Class<?> cast){
		webClient = WebClient.create();
		return webClient.post().
		  uri(uri)
		  .body(BodyInserters.fromMultipartData(param))
		  .retrieve()
		  .bodyToFlux(cast.getClass());		
	}
	
	// PUT
		public Mono<?> put(String uri,MultiValueMap<String, Object> param,Class<?> cast){
			webClient = WebClient.create();
			return webClient.put().
			  uri(uri)
			  .body(BodyInserters.fromMultipartData(param))
			  .retrieve()
			  .bodyToMono(cast.getClass());		
		}
		public Flux<?> putList(String uri,MultiValueMap<String, Object> param,Class<?> cast){
			webClient = WebClient.create();
			return webClient.put().
			  uri(uri)
			  .body(BodyInserters.fromMultipartData(param))
			  .retrieve()
			  .bodyToFlux(cast.getClass());		
		}
		
		// DELETE
		public Mono<?> delete(String uri,Consumer<Map<String, Object>> param,Class<?> cast){
			webClient = WebClient.create();
			return webClient.delete()
			  .uri(uri)
			  .attributes(param)
			  .retrieve()
			  .bodyToMono(cast.getClass());		
		}
		public Flux<?> deleteList(String uri,Consumer<Map<String, Object>> param,Class<?> cast){
			webClient = WebClient.create();
			return webClient.delete()
					  .uri(uri)
					  .attributes(param)
					  .retrieve()
					  .bodyToFlux(cast.getClass());	
		}
}
