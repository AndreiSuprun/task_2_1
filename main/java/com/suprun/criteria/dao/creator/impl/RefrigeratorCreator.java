package com.suprun.criteria.dao.creator.impl;

import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.Refrigerator;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class RefrigeratorCreator implements CreatorCommand {
    
    @Override
    public Appliance create(String line) {
        int powerConsumption = parseIntValue(extractValue(line, SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()));
        int weight = parseIntValue(extractValue(line, SearchCriteria.Refrigerator.WEIGHT.toString()));
        int freezerCapacity = parseIntValue(extractValue(line, SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()));
        int overallCapacity = parseIntValue(extractValue(line, SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()));
        int height = parseIntValue(extractValue(line, SearchCriteria.Refrigerator.HEIGHT.toString()));
        int width = parseIntValue(extractValue(line, SearchCriteria.Refrigerator.WIDTH.toString()));
        Refrigerator refrigerator = new Refrigerator(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
        return refrigerator;
    }
}
