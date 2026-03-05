package com.slom.model;

public class Orbit {
    private long orbitId;
    private String orbitType;
    private double altitude;

    public Orbit(long orbitId,String orbitType, double altitude){
        this.orbitId=orbitId;
        this.orbitType=orbitType;
        this.altitude=altitude;
    }

    public void setOrbitId(long orbitId) {
        this.orbitId = orbitId;
    }
    public long getOrbitId(){
        return orbitId;
    }
    public void setOrbitType(String orbitType){
        this.orbitType=orbitType;
    }
    public String getOrbitType(){
        return orbitType;
    }
    public void setAltitude(double altitude){
        this.altitude=altitude;
    }
    public double getAltitude(){
        return altitude;
    }
}
