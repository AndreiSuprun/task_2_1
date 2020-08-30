package com.suprun.criteria.controller.command.impl;

import com.suprun.criteria.entity.criteria.Criteria;
import com.suprun.criteria.controller.command.ApplianceCommand;

import java.util.HashMap;
import java.util.Map;

public class EmptyApplianceCommand implements ApplianceCommand {

    private static final String EXCEPTIONS = "exceptions";

    public Map<String, Object> execute(Criteria request) {
        Map<String, Object> response = new HashMap<>();
        response.put(EXCEPTIONS, "Invalid request type");
        return response;
    }
}
