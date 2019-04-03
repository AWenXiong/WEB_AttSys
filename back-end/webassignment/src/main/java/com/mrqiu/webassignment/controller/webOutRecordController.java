package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.dto.WebOutRecord;
import com.mrqiu.webassignment.dto.checkLeave;
import com.mrqiu.webassignment.dto.outApplyForCheck;
import com.mrqiu.webassignment.entity.OutApply;
import com.mrqiu.webassignment.entity.OutRecord;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.enu.PassType;
import com.mrqiu.webassignment.service.DepartmentService;
import com.mrqiu.webassignment.service.OutApplyService;
import com.mrqiu.webassignment.service.OutRecordService;
import com.mrqiu.webassignment.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 外出记录controller，用于员工获取个人外出信息
 */

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/outrecord")
public class webOutRecordController {

    @Resource
    private OutApplyService outApplyService;
    @Resource
    private OutRecordService outRecordService;
    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;

    /**
     * 查询员工自己的外出记录
     * @param staff 只需要提供员工id即可
     * @return
     */
    @RequestMapping(value = "/querybyid", produces = "application/json;charset=UTF-8")
    public ArrayList<WebOutRecord> queryOutRecord(@RequestBody Staff staff){

        String acquireStaffId = staff.getSid();
        ArrayList<WebOutRecord> allOut = new ArrayList<>();

        //外出申请
        ArrayList<OutApply> outApplies = outApplyService.queryOutApplyByStaffId(acquireStaffId);
        for (OutApply apply:
             outApplies) {
            allOut.add(new WebOutRecord(apply.getOid(), apply.getOstaffId(), staffService.getStaffName(apply.getOstaffId()), apply.getOstartTime(), apply.getOendTime(),
                    0/*0是申请1是记录*/, PassType.PENDING, apply.getOreason(), staffService.getStaffName(apply.getOpassStaffId()), apply.getOpassStaffId(), staffService.getStaffDepartment(acquireStaffId)));
        }

        //外出记录
        ArrayList<OutRecord> outRecords = outRecordService.queryOutRecordByStaffId(acquireStaffId);
        for (OutRecord record:
             outRecords) {
            allOut.add(new WebOutRecord(record.getOid(), record.getOstaffId(), staffService.getStaffName(acquireStaffId), record.getOstartTime(), record.getOendTime(),
                    1/*0是申请1是记录*/, PassType.PASSED, record.getOreason(), staffService.getStaffName(record.getOpassStaffId()), record.getOpassStaffId(), staffService.getStaffDepartment(acquireStaffId)));
        }

        return allOut;
    }

    /**
     * 获取所有待审批的外出申请
     * @return
     */
    @RequestMapping(value = "/getallapply", produces = "application/json;charset=UTF-8")
    public ArrayList<outApplyForCheck> qureyOutApplyForCheck(){
        ArrayList<OutApply> allOutApply = outApplyService.queryAllOutApply();
        ArrayList<outApplyForCheck> infoNeed = new ArrayList<>();
        for (OutApply applies:
                allOutApply) {
            infoNeed.add(new outApplyForCheck(applies.getOid(), applies.getOstaffId(), applies.getOstartTime(),
                    applies.getOendTime(), applies.getOreason(), applies.getOpassStaffId(), applies.getOstatus(),
                    staffService.getStaffName(applies.getOstaffId()), departmentService.getDepartmentNameById(staffService.getStaffDepartment(applies.getOstaffId()))));
        }
        return infoNeed;
    }

    /**
     * 获取由给定id的领导所审批的请假记录
     * @return
     */
    @RequestMapping(value = "/queryrecord", produces = "application/json;charset=UTF-8")
    public ArrayList<outApplyForCheck> queryOutRecordForCheck(@RequestBody Staff staff){

        String acquireId = staff.getSid();
        ArrayList<outApplyForCheck> allCheck = new ArrayList<>();

        ArrayList<OutRecord> outRecords = outRecordService.queryAllOutRecord();
        for (OutRecord record:
                outRecords) {
            if(acquireId.equals(record.getOpassStaffId())){
                allCheck.add(new outApplyForCheck(record.getOid(), record.getOstaffId(), record.getOstartTime(), record.getOendTime(), record.getOreason(), record.getOpassStaffId(),
                        2/*申请已经通过批准*/, staffService.getStaffName(record.getOstaffId()), departmentService.getDepartmentNameById(staffService.getStaffDepartment(record.getOstaffId()))));
            }
        }
        return allCheck;
    }


    /**
     * 更新外出申请
     * @param webOutRecord 参数只需要申请id（必须），开始、结束时间，外出原因
     * @return
     */
    @RequestMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public WebOperationResult updateOutRecord(@RequestBody WebOutRecord webOutRecord){

        long acquireOutId = webOutRecord.getRecordId();
        Timestamp acquireStartTime = webOutRecord.getStartTime();
        Timestamp acquireEndTime = webOutRecord.getEndTime();
        String acquireReason = webOutRecord.getReason();

        //TODO
        outApplyService.updateOutApply(acquireOutId, acquireStartTime, acquireEndTime, acquireReason);

        return new WebOperationResult(true,"Successfully update leave apply!");
    }

    /**
     * 删除外出申请
     * @param webOutRecord 只要求外出申请id即可
     * @return
     */
    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public WebOperationResult deleteOutRecord(@RequestBody WebOutRecord webOutRecord){

        long acquireOutId = webOutRecord.getRecordId();

        outApplyService.deleteOutApply(acquireOutId);

        return new WebOperationResult(true,"Successfully delete out apply!");
    }

    /**
     * 新增外出申请
     * @param webOutRecord 参数要求员工id，开始、结束时间，外出原因
     * @return
     */
    @RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public WebOperationResult insertLeaveApply(@RequestBody WebOutRecord webOutRecord){

        String acquireStaffId = webOutRecord.getStaffId();
        Timestamp acquireStartTime = webOutRecord.getStartTime();
        Timestamp acquireEndTime = webOutRecord.getEndTime();
        String acquireReason = webOutRecord.getReason();

        outApplyService.insertOutApply(acquireStaffId,acquireStartTime,acquireEndTime, acquireReason);

        return new WebOperationResult(true,"Successfully insert out apply!");
    }

    @RequestMapping(value = "/check", produces = "application/json;charset=UTF-8")
    public WebOperationResult checkOutApply(@RequestBody checkLeave checkLeave){

        long acquireCheckResult = checkLeave.getCheckResult();
        long acquireApplyId = checkLeave.getApplyId();
        String acquirePassStaffId = checkLeave.getPassStaffId();
        if(acquireCheckResult == 1/*同意申请*/){
            outApplyService.updateStatus(acquireApplyId, acquirePassStaffId,3/*database中的同意，1是待定*/);
            outRecordService.insertOutRecord(acquireApplyId);
        }else {
            outApplyService.updateStatus(acquireApplyId, acquirePassStaffId,0/*database中的拒绝*/);
        }

        return new WebOperationResult(true,"Successfully check out apply!");
    }

}
