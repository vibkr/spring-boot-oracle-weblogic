package com.unilever.api.unileverheartbeatapi.model;

import java.sql.Timestamp;

public class OtmToPi {

    private String objectId;
    private String otmSent;
    private String piReceived;
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

    public String getOtmSent() {
        return otmSent;
    }

    public void setOtmSent(String otmSent) {
        this.otmSent = otmSent;
    }

    public String getPiReceived() {
        return piReceived;
    }

    public void setPiReceived(String piReceived) {
        this.piReceived = piReceived;
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
