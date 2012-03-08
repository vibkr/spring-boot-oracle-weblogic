package com.unilever.api.unileverheartbeatapi.service;

import com.unilever.api.unileverheartbeatapi.model.*;

import java.util.List;

public interface HeartBeatService {


    public OtmToPi getOtmToPiFromDataSource(String dataSource);
    public PiToOtm getPiToOtmFromDataSource(String dataSource);
    public OtmPiAndPiOtm getOtmPiAndPiOtm(String dataSource);
    public List<OtmPiAndPiOtm> getOtmPiAndPiOtmForAllDB(String serverName);
    public List<ThresholdReport> getThresholdReport(String dataSource);
    public List<ConnectivityReport> getConnectivityReport(String dataSource);
    List<Report> getReport(String serverName);
}

