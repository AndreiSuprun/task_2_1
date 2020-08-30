package com.suprun.criteria.dao.creator.impl;

import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.Oven;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class OvenCreator implements CreatorCommand {

    @Override
    public Appliance create(String line) {
        int powerConsumption = parseIntValue(extractValue(line, SearchCriteria.Oven.POWER_CONSUMPTION.toString()));
        int weight = parseIntValue(extractValue(line, SearchCriteria.Oven.WEIGHT.toString()));
        int capacity = parseIntValue(extractValue(line, SearchCriteria.Oven.CAPACITY.toString()));
        int depth = parseIntValue(extractValue(line, SearchCriteria.Oven.DEPTH.toString()));
        int height = parseIntValue(extractValue(line, SearchCriteria.Oven.HEIGHT.toString()));
        int width = parseIntValue(extractValue(line, SearchCriteria.Oven.WIDTH.toString()));
        Oven oven = new Oven(powerConsumption, weight, capacity, depth, height, width);
        return oven;
    }
}
