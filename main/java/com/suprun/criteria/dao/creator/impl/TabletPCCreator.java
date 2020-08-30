package com.suprun.criteria.dao.creator.impl;

import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.TabletPC;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class TabletPCCreator implements CreatorCommand {
    
    @Override
    public Appliance create(String line) {
        double batteryCapacity = parseDoubleValue(extractValue(line, SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()));
        int displayInches = parseIntValue(extractValue(line, SearchCriteria.TabletPC.DISPLAY_INCHES.toString()));
        int memoryRom = parseIntValue(extractValue(line, SearchCriteria.TabletPC.MEMORY_ROM.toString()));
        int flashMemoryCapacity = parseIntValue(extractValue(line, SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()));
        TabletPC.Color color = TabletPC.Color.valueOf((extractValue(line, SearchCriteria.TabletPC.COLOR.toString())).toUpperCase());
        TabletPC tabletPC = new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
        return tabletPC;
    }
}
