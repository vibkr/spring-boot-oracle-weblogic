package com.unilever.api.unileverheartbeatapi.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unilever.api.unileverheartbeatapi.model.OtmToPi;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class OtmToPiMapper implements RowMapper<OtmToPi>{

    @Override
    public OtmToPi mapRow(ResultSet rs, int rowNum) throws SQLException {
        OtmToPi otmToPi = new OtmToPi();
        otmToPi.setObjectId(rs.getString("OBJECT_ID"));
        otmToPi.setOtmSent(rs.getString("OTM_SENT"));
        otmToPi.setPiReceived(rs.getString("PI_RECEIVED"));
        otmToPi.setTransmission(rs.getLong("TRANSMISSION"));
        otmToPi.setCurrentRun(rs.getTimestamp("CURRENT_RUN"));
        otmToPi.setNextRun(rs.getTimestamp("NEXT_RUN"));
        return otmToPi;
    }


}

