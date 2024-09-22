package com.sravan.springboot.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;

public class EmployeeDetailsUtil {

	public static List<EmployeeDetailsResponse> parseResultsToObjects(List<Object[]> employees) {
		List<EmployeeDetailsResponse> responseList = new ArrayList<>();
		for (Object[] result : employees) {
			EmployeeDetailsResponse response = new EmployeeDetailsResponse((int) result[0], // employeeId
					(String) result[1], // lastName
					(String) result[2], // firstName
					(String) result[3], // employeeType
					(String) result[4], // region
					(String) result[5], // designation
					(String) result[6], // email
					(String) result[7] // yearsOfService
			);
			responseList.add(response);
		}
		return responseList;
	}
}
