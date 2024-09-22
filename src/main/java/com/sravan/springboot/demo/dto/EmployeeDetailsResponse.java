package com.sravan.springboot.demo.dto;

public class EmployeeDetailsResponse {

	public EmployeeDetailsResponse(int employeeId, String firstName, String lastName, String employeeType,
			String region, String designation, String email, String yearsOfService) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeType = employeeType;
		this.region = region;
		this.designation = designation;
		this.email = email;
		this.yearsOfService = yearsOfService;
	}

	private int employeeId;

	private String firstName;

	private String lastName;

	private String employeeType;

	private String region;

	private String designation;

	private String email;

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsResponse [firstName=" + firstName + ", lastName=" + lastName + ", employeeId="
				+ employeeId + ", employeeType=" + employeeType + ", region=" + region + ", designation=" + designation
				+ ", email=" + email + ", yearsOfService=" + yearsOfService + "]";
	}

}
