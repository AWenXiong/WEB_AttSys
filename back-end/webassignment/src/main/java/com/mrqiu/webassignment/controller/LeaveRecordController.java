package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.Exception.NoLeaveRecordException;
import com.mrqiu.webassignment.Exception.NoStaffException;
import com.mrqiu.webassignment.Exception.TimeException;
import com.mrqiu.webassignment.dto.WebLeaveRecord;
import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.entity.LeaveApply;
import com.mrqiu.webassignment.entity.LeaveRecord;
import com.mrqiu.webassignment.service.LeaveRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping("/leaverecord1")
public class LeaveRecordController {

    @Resource
    private LeaveRecordService leaveRecordService;

    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public ArrayList<LeaveRecord> getAllLeaveRecord(){
        return leaveRecordService.queryAllLeaveRecord();
    }

    @RequestMapping(value = "/querybyid", produces = "application/json;charset=UTF-8")
    public ArrayList<LeaveRecord> getLeaveRecordByStaffId(@RequestBody WebLeaveRecord webLeaveRecord){
        try{
            ArrayList<LeaveRecord> result = leaveRecordService.queryLeaveRecordByStaffId(webLeaveRecord.getStaffId());
            return result;
        } catch (NoStaffException e1){
            e1.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/querybytime", produces = "application/json;charset=UTF-8")
    public ArrayList<LeaveRecord> getLeaveRecordByTime(@RequestBody WebLeaveRecord webLeaveRecord){
        try{
            ArrayList<LeaveRecord> result = leaveRecordService
                    .queryLeaveRecordByTime(webLeaveRecord.getStartTime(), webLeaveRecord.getEndTime());
            return result;
        } catch (TimeException e1){
            e1.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public WebOperationResult deleteLeaveRecord(@RequestBody WebLeaveRecord webLeaveRecord){
        if (webLeaveRecord.getKind() != 1) {//0代表申请，1代表记录
            return new WebOperationResult(false, "Bad Request!");
        }
        try{
            leaveRecordService.deleteLeaveRecord(webLeaveRecord.getRecordId());
            return new WebOperationResult(true, "Successfully delete leave record");
        } catch(NoLeaveRecordException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "No leave record error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /leaverecord/delete");
        }
    }
}
