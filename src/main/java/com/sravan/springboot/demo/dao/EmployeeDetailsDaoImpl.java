package com.sravan.springboot.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;
import com.sravan.springboot.demo.dto.PaginatedResponse;
import com.sravan.springboot.demo.util.EmployeeDetailsUtil;
import com.sravan.springboot.demo.util.QueryUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {

	private EntityManager entityManager;

	public EmployeeDetailsDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<EmployeeDetailsResponse> findAll() {
		String jpql = "SELECT e.employeeId, e.firstName, e.lastName, ed.employeeType, ed.region, ed.designation, ed.email, ed.yearsOfService"
				+ " FROM Employee e JOIN EmployeeDetails ed ON e.employeeId=ed.employeeId";
		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

		List<Object[]> employees = query.getResultList();

		return EmployeeDetailsUtil.parseResultsToObjects(employees);
	}

	@Override
	public PaginatedResponse searchByFilter(Map<String, String> queryParams) {

		int pageSize = queryParams.containsKey("pageSize") ? Integer.parseInt(queryParams.get("pageSize")) : 5;
		int pageNumber = queryParams.containsKey("pageNumber") ? Integer.parseInt(queryParams.get("pageNumber")) : 1;

		StringBuilder countQueryBuilder = new StringBuilder(
				"SELECT COUNT(e.employeeId) FROM Employee e JOIN EmployeeDetails ed ON e.employeeId=ed.employeeId");
		String countQuery = QueryUtil.formatForJpql(countQueryBuilder, queryParams, "ed");

		TypedQuery<Long> totalResults = entityManager.createQuery(countQuery, Long.class);
		totalResults = QueryUtil.formatQueryCount(totalResults, queryParams);
		int totalCount = totalResults.getSingleResult().intValue();

		int maxPages = totalCount % pageSize != 0 ? totalCount / pageSize + 1 : totalCount / pageSize;

		StringBuilder jpqlBuilder = new StringBuilder(
				"SELECT e.employeeId, e.firstName, e.lastName, ed.employeeType, ed.region, ed.designation, ed.email, ed.yearsOfService"
						+ " FROM Employee e JOIN EmployeeDetails ed ON e.employeeId=ed.employeeId");
		String jpql = QueryUtil.formatForJpql(jpqlBuilder, queryParams, "ed");

		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		query = QueryUtil.formatQueryParameters(query, queryParams);

		List<Object[]> employees = query.getResultList();

		List<EmployeeDetailsResponse> responseList = EmployeeDetailsUtil.parseResultsToObjects(employees);

		return new PaginatedResponse(pageNumber, pageSize, totalCount, maxPages, responseList);
	}

}
