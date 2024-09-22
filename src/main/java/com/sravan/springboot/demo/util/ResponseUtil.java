package com.sravan.springboot.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtil {

	public ResponseUtil() {
	}

	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

	public static <T> String convertToJson(T value) {
		String jsonOutput = null;
		try {
			jsonOutput = objectMapper.writeValueAsString(value);
			LOGGER.trace("List in JSON format: {}", jsonOutput);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error converting list to JSON", e);
		}
		return jsonOutput;
	}

}
