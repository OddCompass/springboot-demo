package com.sravan.springboot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sravan.springboot.demo.service.TestService;

/*
 * The controller exposes API to its network access. 
 * Can be extended to expose application health, version and other application details
 */

@RestController
@RequestMapping("/check")
public class TestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	private TestService testService;

	public TestController(TestService testService) {
		super();
		this.testService = testService;
	}

	@GetMapping("/networkaccess")
	public ResponseEntity<String> testNetworkAccess(@RequestParam String url) {
		LOGGER.info("Incoming Request: method={}, uri={}, validateUrl={}", "GET", "/check/networkaccess", url);
		ResponseEntity<String> response = testService.testNetworkAccess(url);
		LOGGER.info("Outgoing Response status: {}", response.getStatusCode());
		LOGGER.debug("Outgoing Response: {}", response.getBody());
		return response;

	}

}
