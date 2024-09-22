package com.sravan.springboot.demo.service;

import java.util.List;
import java.util.Map;

import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;
import com.sravan.springboot.demo.dto.PaginatedResponse;

public interface EmployeeDetailsService {

	public List<EmployeeDetailsResponse> findAll();

	public PaginatedResponse searchByFilter(Map<String, String> queryParams);

}
