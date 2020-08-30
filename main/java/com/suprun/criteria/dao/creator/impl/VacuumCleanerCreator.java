package com.suprun.criteria.dao.creator.impl;

import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.VacuumCleaner;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class VacuumCleanerCreator implements CreatorCommand {
    
    @Override
    public Appliance create(String line) {
        int powerConsumption = parseIntValue(extractValue(line, SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()));
        VacuumCleaner.FilterType filterType = VacuumCleaner.FilterType.valueOf((extractValue(line,
                SearchCriteria.VacuumCleaner.FILTER_TYPE.toString())).toUpperCase());
        VacuumCleaner.BagType bagType = VacuumCleaner.BagType.valueOf((extractValue(line,
                SearchCriteria.VacuumCleaner.BAG_TYPE.toString())).toUpperCase());
        String wandType = extractValue(line, SearchCriteria.VacuumCleaner.WAND_TYPE.toString());
        int motorSpeedRegulation = parseIntValue(extractValue(line,
                SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()));
        int cleaningWidth = parseIntValue(extractValue(line, SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()));
        VacuumCleaner vacuumCleaner = new VacuumCleaner(powerConsumption, filterType, bagType, wandType,
                motorSpeedRegulation, cleaningWidth);
        return vacuumCleaner;
    }
}
