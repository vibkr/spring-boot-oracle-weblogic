package com.unilever.api.unileverheartbeatapi.rowmappers;

import com.unilever.api.unileverheartbeatapi.model.ConnectivityReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("rawtypes")
public class ConnectivityReportMapper implements RowMapper<ConnectivityReport> {

    @Override
    public ConnectivityReport mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConnectivityReport connectivityReport = new ConnectivityReport();
        connectivityReport.setOtmSent(rs.getString("OTM_SENT"));
        connectivityReport.setPiReceived(rs.getString("PI_RECEIVED"));
        connectivityReport.setPiSent(rs.getString("PI_SENT"));
        connectivityReport.setOtmReceived(rs.getString("OTM_RECEIVED"));
        connectivityReport.setObjectId(rs.getString("OBJECT_ID"));
        connectivityReport.setOutboundTransmission(rs.getString("OUTBOUND_TRANSMISSION"));
        connectivityReport.setInboundTransmission(rs.getString("INBOUND_TRANSMISSION"));
        return connectivityReport;
    }


}