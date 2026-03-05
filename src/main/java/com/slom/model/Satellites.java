package com.slom.model;

public class Satellites {
    private long satId;
    private String name;
    private String type;
    private String manufacturer;

    public Satellites(long satId,String name, String type, String manufacturer ){
        this.satId=satId;
        this.name=name;
        this.type=type;
        this.manufacturer=manufacturer;
    }

    public void setSatId(long satId) {
        this.satId=satId;
    }
    public long getSatId() {
        return satId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }
}
