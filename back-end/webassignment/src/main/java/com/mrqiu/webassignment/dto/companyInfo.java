package com.mrqiu.webassignment.dto;

import java.sql.Timestamp;

public class companyInfo {
    private String infoName;//信息所属员工姓名
    private Timestamp infoStartTime;
    private Timestamp infoEndTime;
    private String infoDepartment;

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public Timestamp getInfoStartTime() {
        return infoStartTime;
    }

    public void setInfoStartTime(Timestamp infoStartTime) {
        this.infoStartTime = infoStartTime;
    }

    public Timestamp getInfoEndTime() {
        return infoEndTime;
    }

    public void setInfoEndTime(Timestamp infoEndTime) {
        this.infoEndTime = infoEndTime;
    }

    public String getInfoDepartment() {
        return infoDepartment;
    }

    public void setInfoDepartment(String infoDepartment) {
        this.infoDepartment = infoDepartment;
    }

    public companyInfo(String infoName, Timestamp infoStartTime, Timestamp infoEndTime, String infoDepartment) {
        this.infoName = infoName;
        this.infoStartTime = infoStartTime;
        this.infoEndTime = infoEndTime;
        this.infoDepartment = infoDepartment;
    }

    public companyInfo(String infoName, String infoDepartment) {
        this.infoName = infoName;
        this.infoDepartment = infoDepartment;
    }
}
