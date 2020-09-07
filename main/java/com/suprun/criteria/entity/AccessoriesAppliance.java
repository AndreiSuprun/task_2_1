package com.suprun.criteria.entity;

public class AccessoriesAppliance implements Appliance{

    protected int powerConsumption;

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}

