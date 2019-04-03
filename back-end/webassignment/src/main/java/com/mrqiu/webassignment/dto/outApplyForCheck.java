package com.mrqiu.webassignment.dto;

import java.sql.Timestamp;

public class outApplyForCheck {
    private long oid;
    private String ostaffId;
    private Timestamp ostartTime;
    private Timestamp oendTime;
    private String oreason;
    private String opassStaffId;
    private long ostatus;
    private String ostaffName;
    private String ostaffDepartment;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public String getOstaffId() {
        return ostaffId;
    }

    public void setOstaffId(String ostaffId) {
        this.ostaffId = ostaffId;
    }

    public Timestamp getOstartTime() {
        return ostartTime;
    }

    public void setOstartTime(Timestamp ostartTime) {
        this.ostartTime = ostartTime;
    }

    public Timestamp getOendTime() {
        return oendTime;
    }

    public void setOendTime(Timestamp oendTime) {
        this.oendTime = oendTime;
    }


    public String getOreason() {
        return oreason;
    }

    public void setOreason(String oreason) {
        this.oreason = oreason;
    }

    public String getOpassStaffId() {
        return opassStaffId;
    }

    public void setOpassStaffId(String opassStaffId) {
        this.opassStaffId = opassStaffId;
    }

    public long getOstatus() {
        return ostatus;
    }

    public void setOstatus(long ostatus) {
        this.ostatus = ostatus;
    }

    public String getOstaffName() {
        return ostaffName;
    }

    public void setOstaffName(String ostaffName) {
        this.ostaffName = ostaffName;
    }

    public String getOstaffDepartment() {
        return ostaffDepartment;
    }

    public void setOstaffDepartment(String ostaffDepartment) {
        this.ostaffDepartment = ostaffDepartment;
    }

    public outApplyForCheck(long oid, String ostaffId, Timestamp ostartTime, Timestamp oendTime, String oreason, String opassStaffId, long ostatus, String ostaffName, String ostaffDepartment) {
        this.oid = oid;
        this.ostaffId = ostaffId;
        this.ostartTime = ostartTime;
        this.oendTime = oendTime;
        this.oreason = oreason;
        this.opassStaffId = opassStaffId;
        this.ostatus = ostatus;
        this.ostaffName = ostaffName;
        this.ostaffDepartment = ostaffDepartment;
    }
}
