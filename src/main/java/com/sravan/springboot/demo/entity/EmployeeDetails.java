package com.sravan.springboot.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	@Column(name = "employee_id")
	private int employeeId;
	@Column(name = "employee_type")
	private String employeeType;
	@Column(name = "region")
	private String region;
	@Column(name = "designation")
	private String designation;
	@Column(name = "email")
	private String email;
	@Column(name = "years_of_service")
	private String yearsOfService;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(String yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", employeeType=" + employeeType + ", region=" + region
				+ ", designation=" + designation + ", email=" + email + ", yearsOfService=" + yearsOfService + "]";
	}

}
