package com.unilever.api.unileverheartbeatapi.dao;

import com.unilever.api.unileverheartbeatapi.model.ConnectivityReport;
import com.unilever.api.unileverheartbeatapi.model.ThresholdReport;
import com.unilever.api.unileverheartbeatapi.model.OtmToPi;
import com.unilever.api.unileverheartbeatapi.model.PiToOtm;

import java.util.List;

public interface HeartBeatDao {

    public OtmToPi getOtmToPi(String dataSource);

    public PiToOtm getPiToOtm(String dataSource);

    public List<ThresholdReport> getThresholdReport(String dataSource);

    public List<ConnectivityReport> getConnectivityReport(String dataSource);
}
