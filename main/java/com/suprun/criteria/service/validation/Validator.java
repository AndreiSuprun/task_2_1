package com.suprun.criteria.service.validation;

import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.entity.criteria.SearchCriteria;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        String groupSearchName = criteria.getGroupSearchName();
        Class<?>[] classes = SearchCriteria.getClasses();
        Class<?> criteriaClass = null;
        for (Class<?> aClass : classes) {
            if (aClass.getSimpleName().equals(groupSearchName)) {
                criteriaClass = aClass;
                break;
            }
        }
        if (criteriaClass == null) {
            return false;
        }
        List<?> enumConstants = Arrays.asList(criteriaClass.getEnumConstants());
        boolean isParameterPresent = false;
        for (String searchParameter : criteria.getSearchCriteriaSet()) {
            if (searchParameter == null || searchParameter.isEmpty()) {
                return false;
            }
            if (criteria.getSearchCriteriaValue(searchParameter) == null || criteria.getSearchCriteriaValue(searchParameter).isEmpty()) {
                return false;
            }
            for (int i = 0; i < enumConstants.size(); i++) {
                if (enumConstants.get(i).toString().equalsIgnoreCase(searchParameter)) {
                    isParameterPresent = true;
                }
            }
        }
        return isParameterPresent;
    }
}