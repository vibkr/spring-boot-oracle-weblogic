package com.unilever.api.unileverheartbeatapi.rowmappers;

import com.unilever.api.unileverheartbeatapi.model.ThresholdReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


@SuppressWarnings("rawtypes")
public class ThresholdReportMapper implements RowMapper<ThresholdReport> {

    @Override
    public ThresholdReport mapRow(ResultSet rs, int rowNum) throws SQLException {
        ThresholdReport thresholdReport = new ThresholdReport();
        thresholdReport.setOtmSent(rs.getString("OTM_SENT"));
        thresholdReport.setPiReceived(rs.getString("PI_RECEIVED"));
        thresholdReport.setPiSent(rs.getString("PI_SENT"));
        thresholdReport.setOtmReceived(rs.getString("OTM_RECEIVED"));
        thresholdReport.setObjectId(rs.getString("OBJECT_ID"));
        thresholdReport.setProcessingTime(rs.getString("PROCESSING_TIME"));
        thresholdReport.setOutboundTransmission(rs.getString("OUTBOUND_TRANSMISSION"));
        thresholdReport.setInboundTransmission(rs.getString("INBOUND_TRANSMISSION"));
        return thresholdReport;
    }


}
