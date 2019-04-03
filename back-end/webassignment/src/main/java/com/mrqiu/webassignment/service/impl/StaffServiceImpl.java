package com.mrqiu.webassignment.service.impl;

import com.mrqiu.webassignment.dao.StaffDao;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;

    @Override
    public String checkStaff(String userName, String password) {
        return staffDao.checkStaff(userName, password);
    }

    @Override
    public String getStaffName(String staffId) {
        return staffDao.getStaffNameById(staffId);
    }

    @Override
    public String getStaffGender(String staffId) {
        return staffDao.getStaffGenderById(staffId);
    }

    @Override
    public String getStaffDepartment(String staffId) {
        return staffDao.getStaffDepartmentById(staffId);
    }

    @Override
    public String getStaffPosition(String staffId) {
        return staffDao.getStaffPosition(staffId);
    }

    @Override
    public String getStaffContact(String staffId) {
        return staffDao.getStaffContact(staffId);
    }

    @Override
    public String getStaffAddress(String staffId) {
        return staffDao.getStaffAddress(staffId);
    }

    @Override
    public int getSalaryHolidayById(String staffId) {
        return staffDao.getSalaryHolidayById(staffId);
    }

    @Override
    public Timestamp getEntryTime(String staffId) {
        return staffDao.getEntryTime(staffId);
    }

    @Override
    public Staff getStaffById(String staffId) {
        return staffDao.getStaffById(staffId);
    }

    @Override
    public ArrayList<Staff> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public Integer insertStaff(String sid, String saccount, String spassword, String sname, String sgender, String sdid, String sposition, String scontact, String saddress, Timestamp sentryTime, int ssalaryHoliday) {
        return staffDao.insertStaff(sid, saccount,spassword, sname, sgender, sdid, sposition, scontact, saddress, sentryTime, ssalaryHoliday);
    }

    @Override
    public Integer deleteStaff(String staffId) {
        return staffDao.deleteStaff(staffId);
    }

    @Override
    public Integer updateStaff(String sid, String saccount, String spassword, String sname, String sgender, String sdid, String sposition, String scontact, String saddress, Timestamp sentryTime, int ssalaryHoliday) {
        return staffDao.updateStaff(sid, saccount, spassword, sname, sgender, sdid, sposition, scontact, saddress, sentryTime, ssalaryHoliday);
    }

    @Override
    public Integer updateStaffHoliday(String staffId, int salaryHoliday) {
        return staffDao.updateStaffHoliday(staffId, salaryHoliday);
    }
}
