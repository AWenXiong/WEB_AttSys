package com.mrqiu.webassignment.dto;

import com.mrqiu.webassignment.enu.PassType;

import java.sql.Timestamp;
import java.util.ArrayList;

public class WebOutRecord {

    private long recordId;
    private String staffId;
    private String staffName;
    private Timestamp startTime;
    private Timestamp endTime;
    private long kind; //标识是申请还是记录
    private PassType status; //标识已通过、待审批、已拒绝(p.s.没有审批中)
    private String reason;
    private String passStaffName;
    private String passStaffId;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setPassStaffName(String passStaffName) {
        this.passStaffName = passStaffName;
    }

    public String getPassStaffName() {
        return passStaffName;
    }

    public String getPassStaffId() {
        return passStaffId;
    }

    public void setPassStaffId(String passStaffId) {
        this.passStaffId = passStaffId;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public long getKind() {
        return kind;
    }

    public void setKind(long kind) {
        this.kind = kind;
    }

    public PassType getStatus() {
        return status;
    }

    public void setStatus(PassType status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public WebOutRecord(long recordId, String staffId, String staffName, Timestamp startTime, Timestamp endTime, long kind, PassType status, String reason, String passStaffName, String passStaffId, String department) {
        this.recordId = recordId;
        this.staffId = staffId;
        this.staffName = staffName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.kind = kind;
        this.status = status;
        this.reason = reason;
        this.passStaffName = passStaffName;
        this.passStaffId = passStaffId;
        this.department = department;
    }

    private WebOutRecord() {

    }
}
