package com.suprun.criteria.entity.criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Criteria {

	private String requestType;
	private String groupSearchName;
	private Map<String, String> criteria = new HashMap<String, String>();

	public Criteria(String requestType, String groupSearchName) {
		this.requestType = requestType;
		this.groupSearchName = groupSearchName;
	}

	public String getRequestType() {
		return requestType;
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, String value) {
		criteria.put(searchCriteria, value);
	}

	public Set<String> getSearchCriteriaSet() {
		Set<String> searchCriteria = criteria.keySet();
		return searchCriteria;
	}

	public String getSearchCriteriaValue(String searchCriteria) {
		return criteria.get(searchCriteria);
	}
}
