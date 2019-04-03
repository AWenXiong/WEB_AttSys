package com.mrqiu.webassignment.dto;

public class checkLeave {
    private long checkResult;
    private long applyId;
    private String passStaffId;

    public long getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(long checkResult) {
        this.checkResult = checkResult;
    }

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }

    public String getPassStaffId() {
        return passStaffId;
    }

    public void setPassStaffId(String passStaffId) {
        this.passStaffId = passStaffId;
    }

    public checkLeave(long checkResult, long applyId, String passStaffId) {
        this.checkResult = checkResult;
        this.applyId = applyId;
        this.passStaffId = passStaffId;
    }

    public checkLeave() {

    }
}
