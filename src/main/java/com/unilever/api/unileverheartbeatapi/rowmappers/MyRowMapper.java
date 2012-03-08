package com.unilever.api.unileverheartbeatapi.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class MyRowMapper implements RowMapper<Map> {
    public Map mapRow(ResultSet rs, int paramInt) throws SQLException {
        Map response = new HashMap();
        // here we populate the data using the returned cursor resultset
        // response.setTerm(rs.getString("cursor_col1");
        return response;
    }
}
