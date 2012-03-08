package com.unilever.api.unileverheartbeatapi.model;

import java.util.List;

public class Report {

    private String instanceName;
    private List<ThresholdReport> thresholdReportList;
    private List<ConnectivityReport> connectivityReportList;


    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public List<ThresholdReport> getThresholdReportList() {
        return thresholdReportList;
    }

    public void setThresholdReportList(List<ThresholdReport> thresholdReportList) {
        this.thresholdReportList = thresholdReportList;
    }

    public List<ConnectivityReport> getConnectivityReportList() {
        return connectivityReportList;
    }

    public void setConnectivityReportList(List<ConnectivityReport> connectivityReportList) {
        this.connectivityReportList = connectivityReportList;
    }
}
