package com.suprun.criteria.dao.creator;

import com.suprun.criteria.entity.Appliance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface CreatorCommand {

    static final String PARAMETER_VALUE_SELECTOR = ".*%s[=]([-\\w]*)[,\\s+]*.*";

    Appliance create(String line);

    default double parseDoubleValue(String value) {
        if (value == null || value.isEmpty()) {
            return 0.0;
        }
        double doubleValue;
        try {
            doubleValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
        return doubleValue;
    }

    default int parseIntValue(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        int intValue;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
        return intValue;
    }

    default String extractValue(String line, String parameter) {
        String valueSelector = String.format(PARAMETER_VALUE_SELECTOR, parameter);
        Pattern pattern = Pattern.compile(valueSelector);
        Matcher matcher = pattern.matcher(line);
        String value = "";
        if (matcher.find()){
            value = matcher.group(1).trim();
        }
        return value;
    }
}
