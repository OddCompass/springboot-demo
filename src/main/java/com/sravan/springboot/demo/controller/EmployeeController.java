package com.sravan.springboot.demo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;
import com.sravan.springboot.demo.dto.PaginatedResponse;
import com.sravan.springboot.demo.entity.Employee;
import com.sravan.springboot.demo.service.EmployeeDetailsService;
import com.sravan.springboot.demo.service.EmployeeService;
import com.sravan.springboot.demo.util.ResponseUtil;

/*
 * The controller exposes API to manage Employee basic and employment details
 */

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	private EmployeeService employeeService;
	private EmployeeDetailsService employeeDetailsService;

	public EmployeeController(EmployeeService employeeService, EmployeeDetailsService employeeDetailsService) {
		super();
		this.employeeService = employeeService;
		this.employeeDetailsService = employeeDetailsService;
	}

	@GetMapping("/list")
	public List<Employee> list() {
		LOGGER.info("Incoming Request: method={}, uri={}}", "GET", "/employees/list");
		List<Employee> employees = employeeService.findAll();
		LOGGER.info("Outgoing Response: {}", ResponseUtil.convertToJson(employees));
		return employees;
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		LOGGER.info("Incoming Request: method={}, uri={}, requestBody={}", "POST", "/employees", employee);
		Employee employeeResponse = employeeService.save(employee);
		LOGGER.info("Outgoing Response: {}", ResponseUtil.convertToJson(employeeResponse));
		return employeeResponse;

	}

	@PutMapping("/{employeeId}")
	public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
		LOGGER.info("Incoming Request: method={}, uri={}, requestBody={}", "PUT", "/employees/" + employeeId, employee);
		employee.setEmployeeId(employeeId);
		Employee employeeResponse = employeeService.save(employee);
		LOGGER.info("Outgoing Response: {}", ResponseUtil.convertToJson(employeeResponse));
		return employeeResponse;
	}

	@DeleteMapping("/{employeeId}")
	public Employee deleteEmployee(@PathVariable int employeeId) {
		LOGGER.info("Incoming Request: method={}, uri={}", "DELETE", "/employees/" + employeeId);
		Employee employeeResponse = employeeService.delete(employeeId);
		LOGGER.info("Outgoing Response: {}", ResponseUtil.convertToJson(employeeResponse));
		return employeeResponse;
	}

	////////////////

	@GetMapping("/details")
	public List<EmployeeDetailsResponse> details() {
		LOGGER.info("Incoming Request: method={}, uri={}", "GET", "/details");
		List<EmployeeDetailsResponse> response = employeeDetailsService.findAll();
		LOGGER.info("Outgoing Response: {}", ResponseUtil.convertToJson(response));
		return response;
	}

	@GetMapping("/details/search")
	public PaginatedResponse searchBy(@RequestParam Map<String, String> queryParams) {
		LOGGER.info("Incoming Request: method={}, uri={}, queryParams={}", "GET", "/employees/details/search",
				queryParams);
		PaginatedResponse response = employeeDetailsService.searchByFilter(queryParams);
		LOGGER.info("Outgoing Response: {}", ResponseUtil.convertToJson(response));
		return response;
	}

}
