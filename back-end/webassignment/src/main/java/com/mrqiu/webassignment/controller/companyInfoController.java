package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.dto.WebOutRecord;
import com.mrqiu.webassignment.dto.companyInfo;
import com.mrqiu.webassignment.entity.LeaveRecord;
import com.mrqiu.webassignment.entity.OutRecord;
import com.mrqiu.webassignment.service.DepartmentService;
import com.mrqiu.webassignment.service.LeaveRecordService;
import com.mrqiu.webassignment.service.OutRecordService;
import com.mrqiu.webassignment.service.StaffService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 用于获取公司总体情况的Controller
 */

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/company")
public class companyInfoController {

    @Resource
    private  LeaveRecordService leaveRecordService;
    @Resource
    private StaffService staffService;
    @Resource
    private  OutRecordService outRecordService;
    @Resource
    private DepartmentService departmentService;
    /**
     * 获取公司总体不在岗情况，包括请假和外出
     * @param webOutRecord 参数要求姓名和不在岗时间段
     * @return
     */
    @RequestMapping(value = "/information", produces = "application/json;charset=UTF-8")
    public ArrayList<companyInfo> getCompanyInfo(@RequestBody WebOutRecord webOutRecord){

        String acquireName = webOutRecord.getStaffName();
        Timestamp acquireStartTime = webOutRecord.getStartTime();
        Timestamp acquireEndTime = webOutRecord.getEndTime();

        ArrayList<companyInfo> allInfo = new ArrayList<companyInfo>();

        //首先取出请假记录
        ArrayList<LeaveRecord> leaveRecords = leaveRecordService.queryAllLeaveRecord();
        for (LeaveRecord  record:
             leaveRecords) {
            //在所有请假记录中判断1、名字是否匹配 2、查询时间段包含记录时间段，如果都满足，插入返回结果数组中
            if(acquireName.equals(staffService.getStaffName(record.getLstaffId())) && acquireStartTime.before(record.getLstartTime()) && acquireEndTime.after(record.getLendTime())){
                allInfo.add(new companyInfo(acquireName, record.getLstartTime(), record.getLendTime(), departmentService.getDepartmentNameById(staffService.getStaffDepartment(record.getLstaffId()))));
            }
        }
        //其次取出外出记录
        ArrayList<OutRecord> outRecords = outRecordService.queryAllOutRecord();
        for (OutRecord record:
             outRecords) {
            if(acquireName.equals(staffService.getStaffName(record.getOstaffId())) && acquireStartTime.before(record.getOstartTime()) && acquireEndTime.after(record.getOendTime())){
                allInfo.add(new companyInfo(acquireName, record.getOstartTime(), record.getOendTime(), departmentService.getDepartmentNameById(staffService.getStaffDepartment(record.getOstaffId()))));
            }
        }

        return allInfo;
    }

}
