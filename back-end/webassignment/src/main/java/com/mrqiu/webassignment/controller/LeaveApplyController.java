package com.mrqiu.webassignment.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mrqiu.webassignment.Exception.*;
import com.mrqiu.webassignment.dto.WebLeaveRecord;
import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.entity.LeaveApply;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.LeaveApplyService;
import com.mrqiu.webassignment.service.LeaveRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/leaveapply1")
public class LeaveApplyController {

    @Resource
    private LeaveApplyService leaveApplyService;
    @Resource
    private LeaveRecordService leaveRecordService;

    @RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public WebOperationResult addLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){
        if (webLeaveRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false,"Bad Request!");
        }
        try{
            leaveApplyService.insertLeaveApply(webLeaveRecord.getStaffId(), webLeaveRecord.getStartTime(), webLeaveRecord.getEndTime(),
                    webLeaveRecord.getReason(), webLeaveRecord.getLeaveKind());
            return new WebOperationResult(true,"Successfully insert leave apply!");
        } catch (NoStaffException e1){
            e1.printStackTrace();
            return new WebOperationResult(false,"Staff not exist!");
        } catch (TimeException e2){
            e2.printStackTrace();
            return new WebOperationResult(false,"Illegal time!");
        } catch (PriorityException e3){
            e3.printStackTrace();
            return new WebOperationResult(false,"Priority error!");
        } catch (LeaveKindException e4){
            e4.printStackTrace();
            return new WebOperationResult(false,"Leave kind error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false,"Unknown error in /leaveapply/add !");
        }
    }

    @RequestMapping(value = "/queryall", produces = "application/json;charset=UTF-8")
            public ArrayList<LeaveApply> queryAllLeaveApply(){
        return leaveApplyService.queryAllLeaveApply();
    }

    @RequestMapping(value = "/querybyid", produces = "application/json;charset=UTF-8")
    public ArrayList<LeaveApply> queryLeaveApplyByStaffId(@RequestBody Staff staff){
        try{
            ArrayList<LeaveApply> result = leaveApplyService.queryLeaveApplyByStaffId(staff.getSid());
            return result;
        } catch(NoStaffException e1){
            e1.printStackTrace();
            return null;
        }
    }

    //TODO
    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public WebOperationResult deleteLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){
        if (webLeaveRecord.getKind() != 0) {//0代表申请，1代表记录
            return new WebOperationResult(false,"Bad request!");
        }
        try{
            leaveApplyService.deleteLeaveApply(webLeaveRecord.getRecordId());
            return new WebOperationResult(true,"Successfully delete leave apply!");
        } catch (NoLeaveApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false,"No leave apply error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false,"Unknown error in /outapply/delete");
        }
    }

    //TODO
    @RequestMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public WebOperationResult updateStatus(@RequestBody WebLeaveRecord webLeaveRecord){
        if (webLeaveRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false,"Bad Request!");
        }
        try{
            leaveApplyService.updateStatus(webLeaveRecord.getRecordId(),
                    webLeaveRecord.getPassStaffId(), webLeaveRecord.getStatus().getIndex());
            return new WebOperationResult(true,"Successfully update leave apply!");
        } catch (NoLeaveApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false,"No leave apply error!");
        } catch (NoStaffException e2){
            e2.printStackTrace();
            return new WebOperationResult(false,"Pass staff not exist!");
        } catch (StatusException e3){
            e3.printStackTrace();
            return new WebOperationResult(false,"Bad status!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false,"Unknown error in /leaveapply/update !");
        }
    }

    @RequestMapping(value = "/agree", produces = "application/json;charset=UTF-8")
    public WebOperationResult agreeLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){
        if (webLeaveRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false,"Bad Request!");
        }
        try{
            leaveRecordService.insertLeaveRecord(webLeaveRecord.getRecordId());
            return new WebOperationResult(true,"Successfully agree leave apply!");
        } catch(NoLeaveApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false,"No leave apply error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false,"Unknown error in /leaveapply/agree !");
        }
    }

    @RequestMapping(value = "/reject", produces = "application/json;charset=UTF-8")
    public WebOperationResult rejectLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){
        if (webLeaveRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false,"Bad Request!");
        }
        try{
            leaveApplyService.updateStatus(webLeaveRecord.getRecordId(), webLeaveRecord.getPassStaffName(),
                    webLeaveRecord.getStatus().getIndex());
            return new WebOperationResult(true,"Successfully reject leave apply!");
        } catch(NoLeaveApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false,"No leave apply error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false,"Unknown error in /leaveapply/reject !");
        }
    }
}
