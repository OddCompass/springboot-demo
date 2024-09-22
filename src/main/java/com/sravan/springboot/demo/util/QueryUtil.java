package com.sravan.springboot.demo.util;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class QueryUtil {

	public static String formatForJpql(StringBuilder jpql, Map<String, String> queryParams, String tableName) {
		queryParams.forEach((k, v) -> {
			if (!k.equalsIgnoreCase("pageSize") && !k.equalsIgnoreCase("pageNumber")) {
				jpql.append(" AND " + tableName + "." + k + "=:" + k);
			}

		});
		return jpql.toString();
	}

	public static TypedQuery<Object[]> formatQueryParameters(TypedQuery<Object[]> query,
			Map<String, String> queryParams) {
		int pageSize = queryParams.containsKey("pageSize") ? Integer.parseInt(queryParams.get("pageSize")) : 5;
		int pageNumber = queryParams.containsKey("pageNumber") ? Integer.parseInt(queryParams.get("pageNumber")) : 1;
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		queryParams.forEach((k, v) -> {
			if (!k.equalsIgnoreCase("pageSize") && !k.equalsIgnoreCase("pageNumber")) {
				query.setParameter(k, v);
			}

		});
		return query;
	}

	public static TypedQuery<Long> formatQueryCount(TypedQuery<Long> query, Map<String, String> queryParams) {
		queryParams.forEach((k, v) -> {
			if (!k.equalsIgnoreCase("pageSize") && !k.equalsIgnoreCase("pageNumber")) {
				query.setParameter(k, v);
			}

		});
		return query;
	}

	public static int getTotalCount(EntityManager entityManager, String countQueryString) {
		TypedQuery<Long> countQuery = entityManager.createQuery(countQueryString, Long.class);
		return countQuery.getSingleResult().intValue();
	}

}
