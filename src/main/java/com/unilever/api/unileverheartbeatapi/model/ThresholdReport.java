package com.unilever.api.unileverheartbeatapi.model;


public class ThresholdReport {

    private String otmSent;
    private String piReceived;
    private String piSent;
    private String otmReceived;
    private String objectId;
    private String processingTime;
    private String outboundTransmission;
    private String inboundTransmission;

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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    public String getOutboundTransmission() {
        return outboundTransmission;
    }

    public void setOutboundTransmission(String outboundTransmission) {
        this.outboundTransmission = outboundTransmission;
    }

    public String getInboundTransmission() {
        return inboundTransmission;
    }

    public void setInboundTransmission(String inboundTransmission) {
        this.inboundTransmission = inboundTransmission;
    }
}
