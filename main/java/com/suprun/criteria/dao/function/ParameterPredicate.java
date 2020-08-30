package com.suprun.criteria.dao.function;

import com.suprun.criteria.entity.criteria.Criteria;

import java.util.function.BiPredicate;

public class ParameterPredicate implements BiPredicate<String, Criteria> {

    static final String PARAMETER_SELECTOR = ".*%s=(?i)(%s)[,\\s+]*.*";

    @Override
    public boolean test(String line, Criteria criteria) {
        if (!line.contains(criteria.getGroupSearchName())){
            return false;
        }
        boolean isParameterValid = false;
        for (String criteriaSearch : criteria.getSearchCriteriaSet()) {
            String valueSelector = String.format(PARAMETER_SELECTOR, criteriaSearch, criteria.getSearchCriteriaValue(criteriaSearch));
            if (line.contains(criteriaSearch) && line.matches(valueSelector)) {
                isParameterValid = true;
            } else {
                return false;
            }
        }
        return isParameterValid;
    }
}
