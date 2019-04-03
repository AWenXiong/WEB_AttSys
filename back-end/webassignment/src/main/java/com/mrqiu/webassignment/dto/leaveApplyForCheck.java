package com.mrqiu.webassignment.dto;

import java.sql.Timestamp;

public class leaveApplyForCheck {
    private long lid;
    private String lstaffId;
    private Timestamp lstartTime;
    private Timestamp lendTime;
    private String lreason;
    private String lpassStaffId;
    private long lkind;
    private long lstatus;
    private String lstaffName;
    private String lstaffDepartment;


    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }


    public String getLstaffId() {
        return lstaffId;
    }

    public void setLstaffId(String lstaffId) {
        this.lstaffId = lstaffId;
    }


    public Timestamp getLstartTime() {
        return lstartTime;
    }

    public void setLstartTime(Timestamp lstartTime) {
        this.lstartTime = lstartTime;
    }


    public Timestamp getLendTime() {
        return lendTime;
    }

    public void setLendTime(Timestamp lendTime) {
        this.lendTime = lendTime;
    }



    public String getLreason() {
        return lreason;
    }

    public void setLreason(String lreason) {
        this.lreason = lreason;
    }


    public String getLpassStaffId() {
        return lpassStaffId;
    }

    public void setLpassStaffId(String lpassStaffId) {
        this.lpassStaffId = lpassStaffId;
    }


    public long getLkind() {
        return lkind;
    }

    public void setLkind(long lkind) {
        this.lkind = lkind;
    }


    public long getLstatus() {
        return lstatus;
    }

    public void setLstatus(long lstatus) {
        this.lstatus = lstatus;
    }

    public String getLstaffName() {
        return lstaffName;
    }

    public void setLstaffName(String lstaffName) {
        this.lstaffName = lstaffName;
    }

    public String getLstaffDepartment() {
        return lstaffDepartment;
    }

    public void setLstaffDepartment(String lstaffDepartment) {
        this.lstaffDepartment = lstaffDepartment;
    }

    public leaveApplyForCheck(long lid, String lstaffId, Timestamp lstartTime, Timestamp lendTime, String lreason, String lpassStaffId, long lkind, long lstatus, String lstaffName, String lstaffDepartment) {
        this.lid = lid;
        this.lstaffId = lstaffId;
        this.lstartTime = lstartTime;
        this.lendTime = lendTime;
        this.lreason = lreason;
        this.lpassStaffId = lpassStaffId;
        this.lkind = lkind;
        this.lstatus = lstatus;
        this.lstaffName = lstaffName;
        this.lstaffDepartment = lstaffDepartment;
    }
}
