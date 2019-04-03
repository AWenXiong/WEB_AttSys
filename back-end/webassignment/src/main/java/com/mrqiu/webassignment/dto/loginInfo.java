package com.mrqiu.webassignment.dto;

public class loginInfo {

    String staffId;

    String staffPosition;

    String staffDepartment;

    int staffSalaryHoliday;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public int getStaffSalaryHoliday() {
        return staffSalaryHoliday;
    }

    public void setStaffSalaryHoliday(int staffSalaryHoliday) {
        this.staffSalaryHoliday = staffSalaryHoliday;
    }

    public loginInfo(String staffId, String staffPosition, String staffDepartment, int staffSalaryHoliday) {
        this.staffId = staffId;
        this.staffPosition = staffPosition;
        this.staffDepartment = staffDepartment;
        this.staffSalaryHoliday = staffSalaryHoliday;
    }

    public  loginInfo(){

    }

}
