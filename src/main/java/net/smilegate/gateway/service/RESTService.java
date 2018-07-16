package net.smilegate.gateway.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.smilegate.gateway.model.USER;

@Service
public class RESTService<T> {

	private final static String LOCALURI = "http://127.0.0.1:8080/api"; 
	private final static String SERVERURI = "http://10.250.64.157:5000/api";
	private final static String DOMAIN = "/users";
	
	private final static URI URL = URI.create(LOCALURI + DOMAIN);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	private RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public List<T> getList() {
		return restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<T>>() {}).getBody();
	}

//	@SuppressWarnings("unchecked")
//	public T get(final String s) {
//		URI url = URI.create(URL + "/" + s);
//		return (T) restTemplate.getForObject(url, Object.class);
//	}
	
	public USER get(final String s) {
		URI url = URI.create(URL + "/" + s);
		return restTemplate.getForObject(url, USER.class);
	}

	public void post(final T obj) {
		restTemplate.postForObject(URL, obj, Object.class);
	}

	public void put(final String s, final T obj) {
		String reqParams = "/" + s;
		restTemplate.put(URL + reqParams, obj);
	}

	public void delete(final String s) {
		String reqParams = "/" + s;
		restTemplate.delete(URL + reqParams);
	}
	
}
