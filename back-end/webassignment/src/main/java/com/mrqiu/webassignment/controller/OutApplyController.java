package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.Exception.*;
import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.dto.WebOutRecord;
import com.mrqiu.webassignment.entity.OutApply;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.OutApplyService;
import com.mrqiu.webassignment.service.OutRecordService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/outapply1")
public class OutApplyController {

    @Resource
    private OutApplyService outApplyService;
    @Resource
    private OutRecordService outRecordService;

    @RequestMapping(value = "/queryall", produces = "application/json;charset=UTF-8")
    public ArrayList<OutApply> queryAllOutApply(){
        return outApplyService.queryAllOutApply();
    }

    @RequestMapping(value = "/querybyid", produces = "application/json;charset=UTF-8")
    public ArrayList<OutApply> queryOutApplyById(@RequestBody Staff staff){
        try{
            ArrayList<OutApply> result = outApplyService.queryOutApplyByStaffId(staff.getSid());
            return result;
        } catch (NoStaffException e1){
            e1.printStackTrace();
            return null;
        }
    }

    /*@RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public WebOperationResult addOutApply(@RequestBody WebOutRecord webOutRecord){
        if (webOutRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false, "Bad Request");
        }
        try{
            outApplyService.insertOutApply(webOutRecord.getStaffId(), webOutRecord.getStartTime(),
                    webOutRecord.getEndTime(), 0, webOutRecord.getReason());
            return new WebOperationResult(true, "Successfully insert out apply");
        } catch (NoStaffException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "Staff not exist!");
        } catch (TimeException e2){
            e2.printStackTrace();
            return new WebOperationResult(false, "Illegal time!");
        } catch (PriorityException e3){
            e3.printStackTrace();
            return new WebOperationResult(false, "Priority error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /outapply/add");
        }
    }*/

    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public WebOperationResult deleteOutApply(@RequestBody WebOutRecord webOutRecord){
        if (webOutRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false, "Bad Request!");
        }
        try{
            outApplyService.deleteOutApply(webOutRecord.getRecordId());
            return new WebOperationResult(true, "Successfully delete out apply!");
        } catch (NoOutApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "No out apply error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /outapply/delete");
        }
    }

    @RequestMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public WebOperationResult updateStatus(@RequestBody WebOutRecord webOutRecord){
        if (webOutRecord.getKind() != 0){//0代表申请，1代表记录
            return new WebOperationResult(false, "Bad Request");
        }
        try{
            outApplyService.updateStatus(webOutRecord.getRecordId(), webOutRecord.getPassStaffId(),
                    webOutRecord.getStatus().getIndex());
            return new WebOperationResult(true, "Successfully update out apply");
        } catch (NoOutApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "No out apply error!");
        } catch (NoStaffException e2){
            e2.printStackTrace();
            return new WebOperationResult(false, "Staff not exist!");
        } catch (StatusException e3){
            e3.printStackTrace();
            return new WebOperationResult(false, "Status error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /outapply/update");
        }
    }

    @RequestMapping(value = "/agree", produces = "application/json;charset=UTF-8")
    public WebOperationResult agreeOutApply(@RequestBody WebOutRecord webOutRecord){
        if (webOutRecord.getKind() != 0){
            return new WebOperationResult(false, "Bad Request!");
        }
        try{
            outRecordService.insertOutRecord(webOutRecord.getRecordId());
            return new WebOperationResult(true, "Successfully agree out apply!");
        } catch (NoOutApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "No out apply error");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /outapply/agree !");
        }
    }

    @RequestMapping(value = "/reject", produces = "application/json;charset=UTF-8")
    public WebOperationResult rejectOutApply(@RequestBody WebOutRecord webOutRecord){
        if (webOutRecord.getKind() != 0){
            return new WebOperationResult(false, "Bad Request!");
        }
        try{
            outApplyService.updateStatus(webOutRecord.getRecordId(), webOutRecord.getPassStaffId(),
                    webOutRecord.getStatus().getIndex());
            return new WebOperationResult(true, "Successfully reject out apply!");
        } catch (NoOutApplyException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "No out apply error");
        } catch(NoStaffException e2){
            e2.printStackTrace();
            return new WebOperationResult(false, "Pass staff not exist!");
        } catch (StatusException e3){
            e3.printStackTrace();
            return new WebOperationResult(false, "Status error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /outapply/agree !");
        }
    }
}
