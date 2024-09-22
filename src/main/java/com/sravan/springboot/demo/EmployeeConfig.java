package com.sravan.springboot.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * The configuration is used to inject RestTemplate which can be used to make
 * external API calls
 */

@Configuration
public class EmployeeConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
