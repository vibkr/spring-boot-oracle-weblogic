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



public class HeartBeatDaoImpl1 {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//
//    // For Dev Instances
//    @Autowired
//    @Qualifier("uunl86JdbcTemplate")
//    private JdbcTemplate uunl86JdbcTemplate;
//    @Autowired
//    @Qualifier("tunl76JdbcTemplate")
//    private JdbcTemplate tunl76JdbcTemplate;
//    @Autowired
//    @Qualifier("dunl46JdbcTemplate")
//    private JdbcTemplate dunl46JdbcTemplate;
//    @Autowired
//    @Qualifier("uunlv6JdbcTemplate")
//    private JdbcTemplate uunlv6JdbcTemplate;
//    @Autowired
//    @Qualifier("uunl36JdbcTemplate")
//    private JdbcTemplate uunl36JdbcTemplate;
//
//    // For QA Instances
//    @Autowired
//    @Qualifier("uunl56JdbcTemplate")
//    private JdbcTemplate uunl56JdbcTemplate;
//    @Autowired
//    @Qualifier("tunl86JdbcTemplate")
//    private JdbcTemplate tunl86JdbcTemplate;
//    @Autowired
//    @Qualifier("dunl56JdbcTemplate")
//    private JdbcTemplate dunl56JdbcTemplate;
//    @Autowired
//    @Qualifier("uunl16JdbcTemplate")
//    private JdbcTemplate uunl16JdbcTemplate;
//    @Autowired
//    @Qualifier("uunl46JdbcTemplate")
//    private JdbcTemplate uunl46JdbcTemplate;
//    @Autowired
//    @Qualifier("sunlv6JdbcTemplate")
//    private JdbcTemplate sunlv6JdbcTemplate;
//
//    // For Dev Instances
//    @Autowired
//    @Qualifier("uunl76JdbcTemplate")
//    private JdbcTemplate uunl76JdbcTemplate;
//    @Autowired
//    @Qualifier("sunl36JdbcTemplate")
//    private JdbcTemplate sunl36JdbcTemplate;
//    @Autowired
//    @Qualifier("sunl26JdbcTemplate")
//    private JdbcTemplate sunl26JdbcTemplate;
//    @Autowired
//    @Qualifier("sunl56JdbcTemplate")
//    private JdbcTemplate sunl56JdbcTemplate;
//    @Autowired
//    @Qualifier("uunl26JdbcTemplate")
//    private JdbcTemplate uunl26JdbcTemplate;
//
//    private ServiceUtils serviceUtils = new ServiceUtils();
//
//    public OtmToPi getOtmToPi(String dataSource) {
//        List<OtmToPi> otmToPi;
//        otmToPi = getJdbcTemplate(dataSource).query(GET_INBOUND_SQL, new OtmToPiMapper());
//        if(otmToPi.isEmpty()){
//            otmToPi.add(new OtmToPi());
//        }
//        otmToPi.get(0).setInstanceName(dataSource);
//        otmToPi.get(0).setRegionName(serviceUtils.getRegionName(dataSource));
//        return  otmToPi.get(0);
//    }
//
//    public PiToOtm getPiToOtm(String dataSource) {
//        List<PiToOtm> piToOtm;
//        piToOtm = getJdbcTemplate(dataSource).query(GET_OUTBOUND_SQL, new PiToOtmMapper());
//        if(piToOtm.isEmpty()){
//            piToOtm.add(new PiToOtm());
//        }
//        piToOtm.get(0).setInstanceName(dataSource);
//        piToOtm.get(0).setRegionName(serviceUtils.getRegionName(dataSource));
//        return  piToOtm.get(0);
//    }
//
//
//    public List<ThresholdReport> getThresholdReport(String dataSource){
//        List<ThresholdReport> thresholdReport;
//        thresholdReport = getJdbcTemplate(dataSource).query(GET_THRESHOLD_REPORT_SQL, new ThresholdReportMapper());
//        return  thresholdReport;
//    }
//
//    public List<ConnectivityReport> getConnectivityReport(String dataSource){
//
//        List<ConnectivityReport> connectivityReport;
//        connectivityReport = getJdbcTemplate(dataSource).query(GET_CONNECTIVITY_REPORT_SQL, new ConnectivityReportMapper());
//        return  connectivityReport;
//    }
//
//
//    private JdbcTemplate getJdbcTemplate(String dataSourceName) {
//        if(!StringUtils.isEmpty(dataSourceName)) {
//            switch (dataSourceName) {
//                case UUNL86:
//                    return uunl86JdbcTemplate;
//                case TUNL76:
//                    return tunl76JdbcTemplate;
//                case DUNL46:
//                    return dunl46JdbcTemplate;
//                case UUNLV6:
//                    return uunlv6JdbcTemplate;
//                case UUNL36:
//                    return uunl36JdbcTemplate;
//                case UUNL56:
//                    return uunl56JdbcTemplate;
//                case TUNL86:
//                    return tunl86JdbcTemplate;
//                case DUNL56:
//                    return dunl56JdbcTemplate;
//                case UUNL16:
//                    return uunl16JdbcTemplate;
//                case UUNL46:
//                    return uunl46JdbcTemplate;
//                case SUNLV6:
//                    return sunlv6JdbcTemplate;
//                case UUNL76:
//                    return uunl76JdbcTemplate;
//                case SUNL36:
//                    return sunl36JdbcTemplate;
//                case SUNL26:
//                    return sunl26JdbcTemplate;
//                case SUNL56:
//                    return sunl56JdbcTemplate;
//                case UUNL26:
//                    return uunl26JdbcTemplate;
//                default:
//                    throw new IllegalArgumentException("Invalid DataSourceName " + dataSourceName);
//            }
//
//        }
//        return null;
//    }
//

}
