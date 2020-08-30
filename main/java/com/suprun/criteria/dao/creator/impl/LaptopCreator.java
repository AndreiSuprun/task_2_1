package com.suprun.criteria.dao.creator.impl;

import com.suprun.criteria.dao.creator.CreatorCommand;
import com.suprun.criteria.entity.Appliance;
import com.suprun.criteria.entity.Laptop;
import com.suprun.criteria.entity.criteria.SearchCriteria;

public class LaptopCreator implements CreatorCommand {

    @Override
    public Appliance create(String line) {
        double batteryCapacity = parseDoubleValue(extractValue(line, SearchCriteria.Laptop.BATTERY_CAPACITY.toString()));
        Laptop.Os os = Laptop.Os.valueOf((extractValue(line, SearchCriteria.Laptop.OS.toString())).toUpperCase());
        int memoryRom = parseIntValue(extractValue(line, SearchCriteria.Laptop.MEMORY_ROM.toString()));
        int systemMemory = parseIntValue(extractValue(line, SearchCriteria.Laptop.SYSTEM_MEMORY.toString()));
        double cpu = parseDoubleValue(extractValue(line, SearchCriteria.Laptop.CPU.toString()));
        int displayInches = parseIntValue(extractValue(line, SearchCriteria.Laptop.DISPLAY_INCHES.toString()));
        Laptop laptop = new Laptop(batteryCapacity, os, memoryRom, systemMemory, cpu, displayInches);
        return laptop;
    }
}
