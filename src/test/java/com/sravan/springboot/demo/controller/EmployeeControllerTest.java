package com.sravan.springboot.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;
import com.sravan.springboot.demo.dto.PaginatedResponse;
import com.sravan.springboot.demo.entity.Employee;
import com.sravan.springboot.demo.service.EmployeeDetailsService;
import com.sravan.springboot.demo.service.EmployeeService;
import com.sravan.springboot.demo.util.ResponseUtil;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	public EmployeeControllerTest(MockMvc mockMvc) {
		super();
		this.mockMvc = mockMvc;
	}

	@MockBean
	private EmployeeService employeeService;

	@MockBean
	private EmployeeDetailsService employeeDetailsService;

	private static List<Employee> employees = new ArrayList<>();
	private static List<EmployeeDetailsResponse> responseList = new ArrayList<>();

	@BeforeAll
	public static void setupTestData() {
		employees.add(new Employee(1, "Nova", "Peterson"));
		employees.add(new Employee(2, "Rachel", "Neal"));
		employees.add(new Employee(3, "Samson", "Kelley"));

		responseList.add(new EmployeeDetailsResponse(1, "Nova", "Peterson", "permanent", "usa", "manager",
				"nova.peterson@us.com", "5"));
		responseList.add(new EmployeeDetailsResponse(2, "Gabriel", "Ross", "contractor", "eu", "employee",
				"gabriel.ross@us.com", "7"));
	}

	@Test
	void listTest() throws Exception {		
		when(employeeService.findAll()).thenReturn(employees);
		
		mockMvc.perform(get("/employees/list"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].firstName").value("Nova"));
		
		verify(employeeService, times(1)).findAll();
	}

	@Test
	void saveEmployeeTest() throws Exception {
		Employee newEmployee = new Employee(5, "Michael", "Kim");
		when(employeeService.save(any(Employee.class))).thenReturn(newEmployee);

		mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
				.content(ResponseUtil.convertToJson(newEmployee))).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("Michael"));

		verify(employeeService, times(1)).save(any(Employee.class));

	}

	@Test
	void updateEmployeeTest() throws Exception {
		int employeeId = 1;

		Employee newEmployee = new Employee(1, "Michael", "Kim");
		when(employeeService.save(any(Employee.class))).thenReturn(newEmployee);

		mockMvc.perform(put("/employees/{employeeId}", employeeId).contentType(MediaType.APPLICATION_JSON)
				.content(ResponseUtil.convertToJson(newEmployee))).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("Michael"));

		verify(employeeService, times(1)).save(any(Employee.class));

	}

	@Test
	void deleteEmployeeTest() throws Exception {
		int employeeId = 1;

		Employee deleteEmployee = new Employee(1, "Nova", "Peterson");
		when(employeeService.delete(anyInt())).thenReturn(deleteEmployee);

		mockMvc.perform(delete("/employees/{employeeId}", employeeId).contentType(MediaType.APPLICATION_JSON)
				.content(ResponseUtil.convertToJson(deleteEmployee))).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName").value("Nova"));

		verify(employeeService, times(1)).delete(anyInt());

	}

	@Test
	void detailsTest() throws Exception {
		when(employeeDetailsService.findAll()).thenReturn(responseList);
		
		mockMvc.perform(get("/employees/details"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].firstName").value("Nova"))
        .andExpect(jsonPath("$.[0].region").value("usa"));		
		
		verify(employeeDetailsService, times(1)).findAll();

	}

	@Test
	void searchByTest() throws Exception {
		PaginatedResponse<EmployeeDetailsResponse> paginatedResponse = new PaginatedResponse<EmployeeDetailsResponse>(1,
				1, 1, 1, responseList);
		when(employeeDetailsService.searchByFilter(any())).thenReturn(paginatedResponse);

		mockMvc.perform(get("/employees/details/search").param("region", "eu")).andExpect(status().isOk())
				.andExpect(jsonPath("$.pageNumber").value("1"))
				.andExpect(jsonPath("$.pageData[0].firstName").value("Nova"))
				.andExpect(jsonPath("$.pageData[0].region").value("usa"));

		verify(employeeDetailsService, times(1)).searchByFilter(any());
	}

}
