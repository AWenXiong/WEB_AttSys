package com.mrqiu.webassignment.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mrqiu.webassignment.dto.WebLeaveRecord;
import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.dto.loginInfo;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.enu.PassType;
import com.mrqiu.webassignment.service.DepartmentService;
import com.mrqiu.webassignment.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping(value = "/login",produces = "application/json;charset=UTF-8")
    public loginInfo checkStaff(@RequestBody Staff staff){
        //return staffService.checkStaff("谢老板1", "123");
        System.out.println("777");
        String acquireStaffId = staffService.checkStaff(staff.getSaccount(), staff.getSpassword());

        if(acquireStaffId == null){
            return new loginInfo();
        }else{
            return new loginInfo(acquireStaffId, staffService.getStaffPosition(acquireStaffId),
                    departmentService.getDepartmentNameById(staffService.getStaffDepartment(acquireStaffId)), staffService.getSalaryHolidayById(acquireStaffId));
        }

    }

    @RequestMapping(value = "/1")
    @ResponseBody
    public String getStaffName(@RequestBody Staff staff){
        return staffService.getStaffName(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/2")
    public String getStaffGender(@RequestBody Staff staff){
        return staffService.getStaffGender(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/3")
    public String getStaffDepartment(@RequestBody Staff staff){
        return staffService.getStaffDepartment(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/4")
    public String getStaffPosition(@RequestBody Staff staff){
        return staffService.getStaffPosition(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/5")
    public String getStaffContact(@RequestBody Staff staff){
        return staffService.getStaffContact(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/5.5")
    public String getStaffAddress(@RequestBody Staff staff){
        return staffService.getStaffAddress(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/6")
    public int getSalaryHoliday(@RequestBody Staff staff){
        return staffService.getSalaryHolidayById(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/7")
    public Timestamp getEntryTime(@RequestBody Staff staff){
        return staffService.getEntryTime(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/8")
    public Staff getStaffById(@RequestBody Staff staff){
        return staffService.getStaffById(staff.getSid());
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    public ArrayList<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }

    @RequestMapping(value = "/option", produces = "application/json;charset=UTF-8")
    public WebOperationResult testOption(@RequestBody WebLeaveRecord webLeaveRecord){

        return new WebOperationResult(true, webLeaveRecord.getReason());
    }
}
