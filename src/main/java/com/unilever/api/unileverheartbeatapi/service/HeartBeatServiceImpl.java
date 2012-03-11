package com.unilever.api.unileverheartbeatapi.service;

import com.unilever.api.unileverheartbeatapi.dao.HeartBeatDao;
import com.unilever.api.unileverheartbeatapi.model.*;
import com.unilever.api.unileverheartbeatapi.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.unilever.api.unileverheartbeatapi.util.Constants.*;

@Service
public class HeartBeatServiceImpl implements HeartBeatService {
    @Autowired
    private HeartBeatDao heartBeatDao;

    private ServiceUtils serviceUtils = new ServiceUtils();

    public OtmToPi getOtmToPiFromDataSource(String dataSource) {

        return  heartBeatDao.getOtmToPi(dataSource);
    }

    public PiToOtm getPiToOtmFromDataSource(String dataSource) {

        return  heartBeatDao.getPiToOtm(dataSource);
    }

    public OtmPiAndPiOtm getOtmPiAndPiOtm(String dataSource) {
        OtmPiAndPiOtm otmPiAndPiOtm = new OtmPiAndPiOtm();
        otmPiAndPiOtm.setOtmToPi(getOtmToPiFromDataSource(dataSource));
        otmPiAndPiOtm.setPiToOtm(getPiToOtmFromDataSource(dataSource));
        return  otmPiAndPiOtm;
    }

    public List<OtmPiAndPiOtm> getOtmPiAndPiOtmForAllDB(String serverName) {
        List<OtmPiAndPiOtm> otmPiAndPiOtmList = new ArrayList<OtmPiAndPiOtm>();
        List<String> dataSourceList = getDataSourceList(serverName);


        try {
            // Create the threads
            Thread[] threadList = new Thread[dataSourceList.size()*2];
            int i=0;
            // spawn threads
            for (final String dataSource:dataSourceList) {
                final OtmPiAndPiOtm otmPiAndPiOtm = new OtmPiAndPiOtm();
                threadList[i] = new Thread(dataSource) {
                    public void run() {
                        otmPiAndPiOtm.setOtmToPi(getOtmToPiFromDataSource(dataSource));
                    }
                };

                threadList[i].setName("OtmToPi Thread: "+dataSource);
                threadList[i].start();
                //System.out.println("Starting "+threadList[i].getName());
                i++;
                threadList[i] = new Thread(dataSource) {
                    public void run() {
                        otmPiAndPiOtm.setPiToOtm(getPiToOtmFromDataSource(dataSource));
                    }
                };
                threadList[i].setName("PiToOtm Thread: "+dataSource);
                threadList[i].start();
                //System.out.println("Starting "+threadList[i].getName());
                otmPiAndPiOtmList.add(otmPiAndPiOtm);
                i++;
            }

            // wait for all threads to end
            for (i = 0; i < dataSourceList.size()*2; i++) {
                threadList[i].join();
                //System.out.println("Joining "+threadList[i].getName());
            }


        } catch(Exception e) {

        }
        return  otmPiAndPiOtmList;
    }

    private List<String> getDevDataSources() {
        List<String> dataSourceList = new ArrayList<String>();
        dataSourceList.add(UUNL86);
        dataSourceList.add(TUNL76);
        dataSourceList.add(DUNL46);
        dataSourceList.add(UUNLV6);
        dataSourceList.add(UUNL36);
        return  dataSourceList;
    }

    private List<String> getQADataSources() {
        List<String> dataSourceList = new ArrayList<String>();
        dataSourceList.add(UUNL56);
        dataSourceList.add(TUNL86);
        dataSourceList.add(DUNL56);
        dataSourceList.add(UUNL16);
        dataSourceList.add(UUNL46);
        dataSourceList.add(SUNLV6);
        return  dataSourceList;
    }

    private List<String> getRTDataSources() {
        List<String> dataSourceList = new ArrayList<String>();
        dataSourceList.add(UUNL76);
        dataSourceList.add(SUNL36);
        dataSourceList.add(SUNL26);
        dataSourceList.add(SUNL56);
        dataSourceList.add(UUNL26);
        return  dataSourceList;
    }

    private List<String> getProdDataSources() {
        List<String> dataSourceList = new ArrayList<String>();
        dataSourceList.add(PUNL76);
        dataSourceList.add(PUNL36);
        dataSourceList.add(PUNL26);
        dataSourceList.add(PUNL66);
        dataSourceList.add(PUNL56);
        return  dataSourceList;
    }

    public List<ThresholdReport> getThresholdReport(String dataSource){
        return  heartBeatDao.getThresholdReport(dataSource);

    }

    public List<ConnectivityReport> getConnectivityReport(String dataSource){
        return  heartBeatDao.getConnectivityReport(dataSource);

    }

    private List<String> getDataSourceList(String serverName) {
        List<String> dataSourceList = new ArrayList<>();
        if(DEV.equalsIgnoreCase(serverName)) {
            dataSourceList = getDevDataSources();
        } else if(QA.equalsIgnoreCase(serverName)) {
            dataSourceList = getQADataSources();
        } else if(RT.equalsIgnoreCase(serverName)) {
            dataSourceList = getRTDataSources();
        } else if(PROD.equalsIgnoreCase(serverName)) {
            dataSourceList = getProdDataSources();
        }
        return dataSourceList;
    }

    public List<Report> getReport(String serverName){
        List<Report> reportList = new ArrayList<>();
        List<String> dataSourceList = getDataSourceList(serverName);

        try {
            // Create the threads
            Thread[] threadList = new Thread[dataSourceList.size()*2];
            int i=0;
            // spawn threads
            for (final String dataSource:dataSourceList) {
                final Report report = new Report();
                threadList[i] = new Thread(dataSource) {
                    public void run() {
                        report.setInstanceName(serviceUtils.getInstanceName(dataSource));
                        report.setThresholdReportList(getThresholdReport(dataSource));
                    }
                };

                threadList[i].setName("ThresholdReport Thread: "+dataSource);
                threadList[i].start();
                // System.out.println("Starting "+threadList[i].getName());
                i++;
                threadList[i] = new Thread(dataSource) {
                    public void run() {
                        report.setConnectivityReportList(getConnectivityReport(dataSource));
                    }
                };
                threadList[i].setName("ConnectivityReport Thread: "+dataSource);
                threadList[i].start();
                //System.out.println("Starting "+threadList[i].getName());
                reportList.add(report);
                i++;
            }

            // wait for all threads to end
            for (i = 0; i < dataSourceList.size()*2; i++) {
                threadList[i].join();
                //System.out.println("Joining "+threadList[i].getName());
            }


        } catch(Exception e) {

        }
        return reportList;
    }


}
