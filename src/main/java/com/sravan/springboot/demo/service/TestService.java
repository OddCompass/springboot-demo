package com.sravan.springboot.demo.service;

import org.springframework.http.ResponseEntity;

public interface TestService {

	public ResponseEntity<String> testNetworkAccess(String url);
}
