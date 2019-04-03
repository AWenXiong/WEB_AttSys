package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.Exception.NoLeaveRecordException;
import com.mrqiu.webassignment.Exception.NoOutRecordException;
import com.mrqiu.webassignment.Exception.TimeException;
import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.dto.WebOutRecord;
import com.mrqiu.webassignment.entity.OutRecord;
import com.mrqiu.webassignment.service.OutRecordService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
@RequestMapping("/outrecord1")
public class OutRecordController {

    @Resource
    private OutRecordService outRecordService;

    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public ArrayList<OutRecord> getAllOutRecord(){
        return outRecordService.queryAllOutRecord();
    }

    @RequestMapping(value = "/querybyid", produces = "application/json;charset=UTF-8")
    public ArrayList<OutRecord> getLeaveRecordByStaffId(@RequestBody WebOutRecord webOutRecord){
        try{
            ArrayList<OutRecord> result = outRecordService.queryOutRecordByStaffId(webOutRecord.getStaffId());
            return result;
        } catch (NoLeaveRecordException e1){
            e1.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/bytime", produces = "application/json;charset=UTF-8")
    public ArrayList<OutRecord> getOutRecordByTime(@RequestBody WebOutRecord webOutRecord){
        try{
            ArrayList<OutRecord> result = outRecordService.queryOutRecordByTime(webOutRecord.getStartTime(),
                    webOutRecord.getEndTime());
            return result;
        } catch (TimeException e1){
            e1.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public WebOperationResult deleteOutRecord(@RequestBody WebOutRecord webOutRecord){
        if (webOutRecord.getKind() != 1){
            return new WebOperationResult(false, "Bad Request");
        }
        try{
            outRecordService.deleteOutRecord(webOutRecord.getRecordId());
            return new WebOperationResult(true, "Successfully delete out record");
        } catch (NoOutRecordException e1){
            e1.printStackTrace();
            return new WebOperationResult(false, "No out record error!");
        } catch (Exception e){
            e.printStackTrace();
            return new WebOperationResult(false, "Unknown error in /outrecord/delete !");
        }
    }
}
