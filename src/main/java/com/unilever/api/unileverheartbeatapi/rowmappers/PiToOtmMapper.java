package com.unilever.api.unileverheartbeatapi.rowmappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.unilever.api.unileverheartbeatapi.model.PiToOtm;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class PiToOtmMapper implements RowMapper<PiToOtm>{

    @Override
    public PiToOtm mapRow(ResultSet rs, int rowNum) throws SQLException {
        PiToOtm piToOtm = new PiToOtm();
        piToOtm.setObjectId(rs.getString("OBJECT_ID"));
        piToOtm.setPiSent(rs.getString("PI_SENT"));
        piToOtm.setOtmReceived(rs.getString("OTM_RECEIVED"));
        piToOtm.setTransmission(rs.getLong("TRANSMISSION"));
        piToOtm.setCurrentRun(rs.getTimestamp("CURRENT_RUN"));
        piToOtm.setNextRun(rs.getTimestamp("NEXT_RUN"));
        return piToOtm;
    }


}

