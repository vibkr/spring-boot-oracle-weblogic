package com.unilever.api.unileverheartbeatapi.model;

import java.sql.Timestamp;

public class PiToOtm {

    private String objectId;
    private String piSent;
    private String otmReceived;
    private Number transmission;
    private Timestamp currentRun;
    private Timestamp nextRun;
    private String instanceName;
    private String regionName;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPiSent() {
        return piSent;
    }

    public void setPiSent(String piSent) {
        this.piSent = piSent;
    }

    public String getOtmReceived() {
        return otmReceived;
    }

    public void setOtmReceived(String otmReceived) {
        this.otmReceived = otmReceived;
    }

    public Number getTransmission() {
        return transmission;
    }

    public void setTransmission(Number transmission) {
        this.transmission = transmission;
    }

    public Timestamp getCurrentRun() {
        return currentRun;
    }

    public void setCurrentRun(Timestamp currentRun) {
        this.currentRun = currentRun;
    }

    public Timestamp getNextRun() {
        return nextRun;
    }

    public void setNextRun(Timestamp nextRun) {
        this.nextRun = nextRun;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
