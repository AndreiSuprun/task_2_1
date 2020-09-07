package com.suprun.criteria.entity.impl;

import com.suprun.criteria.entity.ComputerAppliance;

public class Laptop extends ComputerAppliance {

    private Os os;
    private int systemMemory;
    private double cpu;

    public Laptop(double batteryCapacity, Os os, int memoryRom, int systemMemory, double cpu, int displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public enum Os{
        WINDOWS("Windows"), LINUX("Linux");
        private String os;
        Os(String os){
            this.os = os;
        }
        public String getOs(){
            return os;
        }
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        if (Double.compare(laptop.batteryCapacity, batteryCapacity) != 0) {
            return false;
        }
        if (memoryRom != laptop.memoryRom) {
            return false;
        }
        if (systemMemory != laptop.systemMemory) {
            return false;
        }
        if (Double.compare(laptop.cpu, cpu) != 0) {
            return false;
        }
        if (displayInches != laptop.displayInches) {
            return false;
        }
        return os == laptop.os;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(batteryCapacity);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (os != null ? os.hashCode() : 0);
        result = 31 * result + memoryRom;
        result = 31 * result + systemMemory;
        temp = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + displayInches;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop {");
        sb.append("batteryCapacity=").append(batteryCapacity);
        sb.append(", os=").append(os);
        sb.append(", memoryRom=").append(memoryRom);
        sb.append(", systemMemory=").append(systemMemory);
        sb.append(", cpu=").append(cpu);
        sb.append(", displayInches=").append(displayInches);
        sb.append('}');
        return sb.toString();
    }
}
