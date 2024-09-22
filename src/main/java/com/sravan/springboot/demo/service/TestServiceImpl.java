package com.sravan.springboot.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

	private RestTemplate restTemplate;

	public TestServiceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public ResponseEntity<String> testNetworkAccess(String url) {
		return restTemplate.getForEntity(url, String.class);
	}

}
