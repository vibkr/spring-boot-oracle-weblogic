package com.unilever.api.unileverheartbeatapi.util;

import org.springframework.util.StringUtils;

import java.sql.Time;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.unilever.api.unileverheartbeatapi.util.Constants.*;

public class ServiceUtils {


    public String getRegionName(String dataSourceName) {
        if(!StringUtils.isEmpty(dataSourceName)) {
            switch (dataSourceName) {
                case UUNL86:
                    return FUSION;
                case TUNL76:
                    return AAR;
                case DUNL46:
                    return EUROPE;
                case UUNLV6:
                    return NA;
                case UUNL36:
                    return LATAM;
                case SUNLV6:
                    return LATAM;
                case UUNL56:
                    return FUSION;
                case TUNL86:
                    return AAR;
                case DUNL56:
                    return EUROPE;
                case UUNL16:
                    return NA;
                case UUNL46:
                    return LATAM;
                case UUNL76:
                    return FUSION;
                case SUNL36:
                    return AAR;
                case SUNL26:
                    return EUROPE;
                case SUNL56:
                    return NA;
                case UUNL26:
                    return LATAM;
                default:
                    throw new IllegalArgumentException("Invalid DataSourceName " + dataSourceName);
            }
        }
        return null;
    }


    public String getInstanceName(String dataSourceName) {
        if(!StringUtils.isEmpty(dataSourceName)) {
            switch (dataSourceName) {
                case UUNL86:
                    return FUSION+"-"+UUNL86;
                case TUNL76:
                    return AAR+"-"+TUNL76;
                case DUNL46:
                    return DUNL46+"-"+EUROPE;
                case UUNLV6:
                    return UUNLV6+"-"+ NA;
                case UUNL36:
                    return UUNL36+"-"+LATAM;
                case UUNL56:
                    return UUNL56+"-"+FUSION;
                case TUNL86:
                    return TUNL86+"-"+AAR;
                case DUNL56:
                    return DUNL56+"-"+EUROPE;
                case UUNL16:
                    return UUNL16+"-"+ NA;
                case UUNL46:
                    return UUNL46+"-"+LATAM;
                case SUNLV6:
                    return SUNLV6+"-"+LATAM;
                case UUNL76:
                    return UUNL76+"-"+FUSION;
                case SUNL36:
                    return SUNL36+"-"+AAR;
                case SUNL26:
                    return SUNL26+"-"+EUROPE;
                case SUNL56:
                    return SUNL56+"-"+ NA;
                case UUNL26:
                    return UUNL26+"-"+LATAM;
                default:
                    throw new IllegalArgumentException("Invalid DataSourceName " + dataSourceName);
            }
        }
        return null;
    }

}
