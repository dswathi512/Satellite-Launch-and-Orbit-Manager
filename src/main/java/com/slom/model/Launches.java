package com.slom.model;

import java.sql.Timestamp;

public class Launches {
    private long launchId;
    private Timestamp launchDate;
    private String launchSite;
    private long satId;
    private long orbitId;

    public Launches(long launchId, Timestamp launchDate, String launchSite, long satId, long orbitId){
        this.launchId=launchId;
        this.launchDate=launchDate;
        this.launchSite=launchSite;
        this.satId=satId;
        this.orbitId=orbitId;
    }

    public void setLaunchId(long launchId){
        this.launchId=launchId;
    }
    public long getLaunchId(){
        return launchId;
    }
    public void setLaunchDate(Timestamp launchDate){
        this.launchDate=launchDate;
    }
    public Timestamp getLaunchDate(){
        return launchDate;
    }
    public void setLaunchSite(String launchSite){
        this.launchSite=launchSite;
    }
    public String getLaunchSite(){
        return launchSite;
    }
    public void setSatId(long satId){
        this.satId=satId;
    }
    public long getSatId(){
        return satId;
    }
    public void setOrbitId(long orbitId){
        this.orbitId=orbitId;
    }
    public long getOrbitId(){
        return orbitId;
    }
}
