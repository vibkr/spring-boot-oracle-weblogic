package com.unilever.api.unileverheartbeatapi.dao;

import com.unilever.api.unileverheartbeatapi.model.ConnectivityReport;
import com.unilever.api.unileverheartbeatapi.model.ThresholdReport;
import com.unilever.api.unileverheartbeatapi.rowmappers.ConnectivityReportMapper;
import com.unilever.api.unileverheartbeatapi.rowmappers.OtmToPiMapper;
import com.unilever.api.unileverheartbeatapi.rowmappers.PiToOtmMapper;
import com.unilever.api.unileverheartbeatapi.rowmappers.ThresholdReportMapper;
import com.unilever.api.unileverheartbeatapi.model.OtmToPi;
import com.unilever.api.unileverheartbeatapi.model.PiToOtm;
import com.unilever.api.unileverheartbeatapi.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


import java.util.List;

import static com.unilever.api.unileverheartbeatapi.util.Constants.*;


@Repository
public class HeartBeatDaoImpl implements HeartBeatDao{

//    @Autowired
//    private JdbcTemplate jdbcTemplate;


    // For Dev Instances
    @Autowired
    @Qualifier("punl76JdbcTemplate")
    private JdbcTemplate punl76JdbcTemplate;
    @Autowired
    @Qualifier("punl36JdbcTemplate")
    private JdbcTemplate punl36JdbcTemplate;
    @Autowired
    @Qualifier("punl26JdbcTemplate")
    private JdbcTemplate punl26JdbcTemplate;
    @Autowired
    @Qualifier("punl66JdbcTemplate")
    private JdbcTemplate punl66JdbcTemplate;
    @Autowired
    @Qualifier("punl56JdbcTemplate")
    private JdbcTemplate punl56JdbcTemplate;



    private ServiceUtils serviceUtils = new ServiceUtils();

    public OtmToPi getOtmToPi(String dataSource) {
        List<OtmToPi> otmToPi;
        otmToPi = getJdbcTemplate(dataSource).query(GET_INBOUND_SQL, new OtmToPiMapper());
        if(otmToPi.isEmpty()){
            otmToPi.add(new OtmToPi());
        }
        otmToPi.get(0).setInstanceName(dataSource);
        otmToPi.get(0).setRegionName(serviceUtils.getRegionName(dataSource));
        return  otmToPi.get(0);
    }

    public PiToOtm getPiToOtm(String dataSource) {
        List<PiToOtm> piToOtm;
        piToOtm = getJdbcTemplate(dataSource).query(GET_OUTBOUND_SQL, new PiToOtmMapper());
        if(piToOtm.isEmpty()){
            piToOtm.add(new PiToOtm());
        }
        piToOtm.get(0).setInstanceName(dataSource);
        piToOtm.get(0).setRegionName(serviceUtils.getRegionName(dataSource));
        return  piToOtm.get(0);
    }


    public List<ThresholdReport> getThresholdReport(String dataSource){
        List<ThresholdReport> thresholdReport;
        thresholdReport = getJdbcTemplate(dataSource).query(GET_THRESHOLD_REPORT_SQL, new ThresholdReportMapper());
        return  thresholdReport;
    }

    public List<ConnectivityReport> getConnectivityReport(String dataSource){

        List<ConnectivityReport> connectivityReport;
        connectivityReport = getJdbcTemplate(dataSource).query(GET_CONNECTIVITY_REPORT_SQL, new ConnectivityReportMapper());
        return  connectivityReport;
    }


    private JdbcTemplate getJdbcTemplate(String dataSourceName) {
        if(!StringUtils.isEmpty(dataSourceName)) {
            switch (dataSourceName) {
                case PUNL76:
                    return punl76JdbcTemplate;
                case PUNL36:
                    return punl36JdbcTemplate;
                case PUNL26:
                    return punl26JdbcTemplate;
                case PUNL66:
                    return punl66JdbcTemplate;
                case PUNL56:
                    return punl56JdbcTemplate;
                default:
                    throw new IllegalArgumentException("Invalid DataSourceName " + dataSourceName);
            }

        }
        return null;
    }


}
