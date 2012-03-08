package com.unilever.api.unileverheartbeatapi.util;

public class Constants {

    public static final String SUCESS = "OK";
    public static final String ERROR = "ERROR";
    public static final String FAILED = "FAILED";
    public static final String WARNING = "WARNING";



    //Prod Datasources
    public static final String OTM_DB_CON_AAR_PUNL36 = "OTM_DB_CON_AAR_PUNL36";
    public static final String OTM_DB_CON_FUSION_PUNL76 = "OTM_DB_CON_FUSION_PUNL76";
    public static final String OTM_DB_CON_LA_PUNL66 = "OTM_DB_CON_LA_PUNL66";
    public static final String OTM_DB_CON_NA_PUNL56 = "OTM_DB_CON_NA_PUNL56";
    public static final String OTM_DB_CON_EU_PUNL26 = "OTM_DB_CON_EU_PUNL26";

    //Dev Datasources
    public static final String OTM_DB_CON_FUSION = "OTM_DB_CON_FUSION";
    public static final String OTM_DB_CONDS = "OTM_DB_CONDS";
    public static final String EUROPE_DUN46_SUPP_DEVDS = "EUROPE_DUN46_SUPP_DEVDS";
    public static final String NA_UUNLV6 = "NA_UUNLV6";
    public static final String LA_UUNL36 = "LA_UUNL36";

    // Dev Server Instances
    public static final String UUNL86 = "UUNL86";
    public static final String TUNL76 = "TUNL76";
    public static final String DUNL46 = "DUNL46";
    public static final String UUNLV6 = "UUNLV6";
    public static final String UUNL36 = "UUNL36";
    public static final String SUNLV6 = "SUNLV6";
    // QA Server Instances
    public static final String UUNL56 = "UUNL56";
    public static final String TUNL86 = "TUNL86";
    public static final String DUNL56 = "DUNL56";
    public static final String UUNL16 = "UUNL16";
    public static final String UUNL46 = "UUNL46";
    // RT Server Instances
    public static final String UUNL76 = "UUNL76";
    public static final String SUNL36 = "SUNL36";
    public static final String SUNL26 = "SUNL26";
    public static final String SUNL56 = "SUNL56";
    public static final String UUNL26 = "UUNL26";

    public static final String FUSION = "FUSION";
    public static final String AAR = "AAR";
    public static final String EUROPE = "EUROPE";
    public static final String LATAM = "LATAM";
    public static final String NA = "NA";

    public static final String DEV = "DEV";
    public static final String QA = "QA";
    public static final String RT = "RT";
    public static final String PROD = "PROD";

    public static final String OTM_DB_CON_EU_DUNL56 = "OTM_DB_CON_EU_DUNL56";
    public static final String AAR_TUNL86 = "AAR_TUNL86";
    public static final String OTM_DB_CON_AAR_SUNL36 = "OTM_DB_CON_AAR_SUNL36";
    public static final String OTM_DB_CON_FU_UUNL76 = "OTM_DB_CON_FU_UUNL76";
    public static final String OTM_DB_CON_LA_UUNL26 = "OTM_DB_CON_LA_UUNL26";
    public static final String OTM_DB_CON_NA_SUNL56 = "OTM_DB_CON_NA_SUNL56";
    public static final String OTM_DB_CON_EU_SUNL26 = "OTM_DB_CON_EU_SUNL26";
    public static final String OTM_DB_CON_NA_UUNL56 = "OTM_DB_CON_NA_UUNL56";
    public static final String OTM_CON_NADS = "OTM_CON_NADS";
    public static final String OTM_DB_CON_LA = "OTM_DB_CON_LA";

    public static final String GET_INBOUND_SQL = "SELECT a.object_id, a.otm_sent, a.pi_received, a. transmission, a.current_run, a.next_run FROM( SELECT d.driver_gid object_id, d.attribute1, TO_CHAR(d.attribute_date1,'DD-MM-YYYY HH24:MI:SS') otm_sent, TO_CHAR(d.attribute_date2,'DD-MM-YYYY HH24:MI:SS') pi_received, i.i_transmission_no transmission, d.insert_date current_run, d.insert_date + ( 1 / 1440) * 15 next_run FROM driver d,i_transaction i WHERE i.object_gid=d.driver_gid AND substr(d.driver_gid,5,1) <> 'P' AND d.attribute1 in ('REQ_OTM_PI_CORDILLERA','REQ_OTM','REQ_OTM_PI_SIRIUS') AND i.STATUS='OUTBOUND' AND i.INSERT_DATE > VPD.GMT_SYSDATE-(1/1440)*15 ORDER BY d.insert_date DESC ) a where ROWNUM<2";
    public static final String GET_OUTBOUND_SQL = "SELECT a.object_id, a.pi_sent, a.otm_received, a. transmission, a.current_run, a.next_run FROM( SELECT d.driver_gid object_id, d.attribute1, TO_CHAR(d.attribute_date3,'DD-MM-YYYY HH24:MI:SS') pi_sent, TO_CHAR(d.attribute_date4,'DD-MM-YYYY HH24:MI:SS') otm_received, i.i_transmission_no transmission, d.insert_date current_run, d.insert_date + ( 1 / 1440) * 15 next_run FROM driver d,i_transaction i WHERE i.object_gid=d.driver_gid AND substr(d.driver_gid,5,1) <> 'P' AND d.attribute1 in ('REQ_OTM_PI_CORDILLERA','REQ_OTM','REQ_OTM_PI_SIRIUS') AND i.STATUS='PROCESSED' AND i.INSERT_DATE > VPD.GMT_SYSDATE-(1/1440)*15 ORDER BY d.insert_date DESC ) a where ROWNUM<2";
    public static final String GET_THRESHOLD_REPORT_SQL = "SELECT TO_CHAR(d.attribute_date1,'DD-MM-YYYY HH24:MI:SS') OTM_SENT, TO_CHAR(d.attribute_date2,'DD-MM-YYYY HH24:MI:SS') PI_RECEIVED, TO_CHAR(d.attribute_date3,'DD-MM-YYYY HH24:MI:SS') PI_SENT, TO_CHAR(d.attribute_date4,'DD-MM-YYYY HH24:MI:SS') OTM_RECEIVED, round((d.attribute_date4-d.attribute_date1)*86400,2) PROCESSING_TIME, d.driver_gid object_id,(SELECT i_transmission_no from i_transaction where object_gid=d.driver_gid AND STATUS='OUTBOUND') OUTBOUND_TRANSMISSION, (SELECT i_transmission_no from i_transaction where object_gid=d.driver_gid AND STATUS='PROCESSED') INBOUND_TRANSMISSION FROM driver d WHERE substr(d.driver_gid,5,1) <> 'P' AND d.attribute_date1 is not null AND d.attribute_date2 is not null AND d.attribute_date3 is not null AND d.attribute_date1 is not null AND round((d.attribute_date4-d.attribute_date1)*86400,2)>5 AND d.insert_date>sysdate-7 ORDER BY d.insert_date DESC";
    public static final String GET_CONNECTIVITY_REPORT_SQL = "SELECT nvl(TO_CHAR(d.attribute_date1,'DD-MM-YYYY HH24:MI:SS'),'NA') OTM_SENT, nvl(TO_CHAR(d.attribute_date2,'DD-MM-YYYY HH24:MI:SS'),'NA') PI_RECEIVED, nvl(TO_CHAR(d.attribute_date3,'DD-MM-YYYY HH24:MI:SS'),'NA') PI_SENT, nvl(TO_CHAR(d.attribute_date4,'DD-MM-YYYY HH24:MI:SS'),'NA') OTM_RECEIVED, d.driver_gid object_id,(SELECT i_transmission_no from i_transaction where object_gid=d.driver_gid AND STATUS='OUTBOUND') OUTBOUND_TRANSMISSION, (SELECT i_transmission_no from i_transaction where object_gid=d.driver_gid AND STATUS='PROCESSED') INBOUND_TRANSMISSION FROM driver d WHERE substr(d.driver_gid,5,1) <> 'P' AND (d.attribute_date1 is null OR d.attribute_date2 is null OR d.attribute_date3 is null OR d.attribute_date4 is null) AND d.insert_date>sysdate-7 ORDER BY d.insert_date DESC";


}
