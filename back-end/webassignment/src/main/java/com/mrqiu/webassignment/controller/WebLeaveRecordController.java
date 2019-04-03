package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.dto.*;
import com.mrqiu.webassignment.entity.LeaveApply;
import com.mrqiu.webassignment.entity.LeaveRecord;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.enu.PassType;
import com.mrqiu.webassignment.service.DepartmentService;
import com.mrqiu.webassignment.service.LeaveApplyService;
import com.mrqiu.webassignment.service.LeaveRecordService;
import com.mrqiu.webassignment.service.StaffService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 请假记录controller，用于获取请假信息
 */

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/leaverecord")
public class WebLeaveRecordController {

    @Resource
    private LeaveApplyService leaveApplyService;
    @Resource
    private LeaveRecordService leaveRecordService;
    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;

    /**
     * 通过id查询请假申请记录（一般用于员工查看自己请假情况）
     * @param staff 只需要提供id即可
     * @return
     */
    @RequestMapping(value = "/querybyid", produces = "application/json;charset=UTF-8")
    public ArrayList<WebLeaveRecord> queryLeaveRecord(@RequestBody Staff staff){

        String acquireStaffId = staff.getSid();
        //员工的所有请假记录(1代表记录)
        ArrayList<LeaveRecord> leaveRecords = leaveRecordService.queryLeaveRecordByStaffId(acquireStaffId);
        ArrayList<WebLeaveRecord> allRecord = new ArrayList<>();
        for (LeaveRecord record:
             leaveRecords) {
            allRecord.add(new WebLeaveRecord(record.getLid(), record.getLstaffId(), staffService.getStaffName(acquireStaffId), record.getLstartTime(), record.getLendTime(),
                    1, record.getLkind()/*这个应该是请假的类别*/, PassType.PASSED, record.getLreason(), staffService.getStaffName(record.getLpassStaffId()), record.getLpassStaffId(),
                    staffService.getStaffDepartment(record.getLstaffId())));
        }
        //员工的所有请假申请
        //TODO:passType还没确定
        ArrayList<LeaveApply> leaveApplies = leaveApplyService.queryLeaveApplyByStaffId(acquireStaffId);
        for (LeaveApply apply:
             leaveApplies) {
            allRecord.add(new WebLeaveRecord(apply.getLid(), apply.getLstaffId(), staffService.getStaffName(acquireStaffId), apply.getLstartTime(), apply.getLendTime(),
                    0, apply.getLkind(), PassType.PENDING/*数据库里是什么类型，就是什么类型*/, apply.getLreason(), staffService.getStaffName(apply.getLpassStaffId()),
                    apply.getLpassStaffId(), staffService.getStaffDepartment(apply.getLstaffId())));
        }

        return allRecord;
    }

    /**
     * 获得所有的请假申请，用于领导审批
     * @return
     */
    @RequestMapping(value = "/getallapply", produces = "application/json;charset=UTF-8")
    public ArrayList<leaveApplyForCheck> queryLeaveApplyForCheck(){
        ArrayList<LeaveApply> allLeaveApply = leaveApplyService.queryAllLeaveApply();
        ArrayList<leaveApplyForCheck> infoNeed = new ArrayList<>();
        for (LeaveApply applies:
             allLeaveApply) {
            infoNeed.add(new leaveApplyForCheck(applies.getLid(), applies.getLstaffId(), applies.getLstartTime(),
                    applies.getLendTime(), applies.getLreason(), applies.getLpassStaffId(), applies.getLkind(),
                    applies.getLstatus(), staffService.getStaffName(applies.getLstaffId()), departmentService.getDepartmentNameById(staffService.getStaffDepartment(applies.getLstaffId()))));
        }
        return infoNeed;
    }

    /**
     * 获取由给定id的领导所审批的请假记录
     * @return
     */
    @RequestMapping(value = "/queryrecord", produces = "application/json;charset=UTF-8")
    public ArrayList<leaveApplyForCheck> queryLeaveRecordForCheck(@RequestBody Staff staff){

        String acquireId = staff.getSid();
        ArrayList<leaveApplyForCheck> allCheck = new ArrayList<>();

        ArrayList<LeaveRecord> leaveRecords = leaveRecordService.queryAllLeaveRecord();
        for (LeaveRecord record:
             leaveRecords) {
            if(acquireId.equals(record.getLpassStaffId())){
                allCheck.add(new leaveApplyForCheck(record.getLid(), record.getLstaffId(), record.getLstartTime(), record.getLendTime(), record.getLreason(),
                        record.getLpassStaffId(), record.getLkind(), 2/*记录已经通过*/, staffService.getStaffName(record.getLstaffId()), departmentService.getDepartmentNameById(staffService.getStaffDepartment(record.getLstaffId()))));
            }
        }
        return allCheck;
    }

    /**
     * 更新请假申请
     * @param webLeaveRecord 参数只要求有申请id，开始、结束时间，请假类别，和原因即可
     * @return
     */
    @RequestMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public WebOperationResult updateLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){

        long acquireApplyId = webLeaveRecord.getRecordId();
        Timestamp acquireStartTime = webLeaveRecord.getStartTime();
        Timestamp acquireEndTime = webLeaveRecord.getEndTime();
        long acquireLeaveKind = webLeaveRecord.getLeaveKind();
        String acquireReason = webLeaveRecord.getReason();

        //TODO
        leaveApplyService.updateLeaveApply(acquireApplyId, acquireStartTime, acquireEndTime, acquireReason, acquireLeaveKind);

        return new WebOperationResult(true,"Successfully update leave apply!");
    }

    /**
     * 删除请假申请
     * @param webLeaveRecord 只要求请假申请id即可
     * @return
     */
    @RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public WebOperationResult deleteLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){

        long acquireLeaveId = webLeaveRecord.getRecordId();
        leaveApplyService.deleteLeaveApply(acquireLeaveId);

        return new WebOperationResult(true,"Successfully delete leave apply!");
    }

    /**
     * 新增请假申请
     * @param webLeaveRecord 参数要求员工id，开始、结束时间，请假类别，请假原因
     * @return
     */
    @RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
    public WebOperationResult insertLeaveApply(@RequestBody WebLeaveRecord webLeaveRecord){

        String acquireStaffId = webLeaveRecord.getStaffId();
        Timestamp acquireStartTime = webLeaveRecord.getStartTime();
        Timestamp acquireEndTime = webLeaveRecord.getEndTime();
        long acquireLeaveKind = webLeaveRecord.getLeaveKind();
        String acquireReason  = webLeaveRecord.getReason();

        leaveApplyService.insertLeaveApply(acquireStaffId, acquireStartTime, acquireEndTime, acquireReason, acquireLeaveKind);

        return new WebOperationResult(true,"Successfully insert leave apply!");
    }

    @RequestMapping(value = "/check", produces = "application/json;charset=UTF-8")
    public WebOperationResult checkLeaveApply(@RequestBody checkLeave checkLeave){

        int Ms = 1000*3600*24;
        long acquireCheckResult = checkLeave.getCheckResult();
        long acquireApplyId = checkLeave.getApplyId();
        String acquirePassStaffId = checkLeave.getPassStaffId();
        LeaveApply acquireLeaveApply = leaveApplyService.qureyLeaveApplyByApplyId(acquireApplyId);
        String acquireStaffId = leaveApplyService.queryStaffIdByLeaveId(acquireApplyId);
        if(acquireCheckResult == 1/*同意申请*/){
            leaveApplyService.updateStatus(acquireApplyId, acquirePassStaffId,3/*database中的同意，1是待定*/);
            leaveRecordService.insertLeaveRecord(acquireApplyId);
            //System.out.println((acquireLeaveApply.getLstartTime().getTime()-acquireLeaveApply.getLendTime().getTime())/(Ms));
            if(acquireLeaveApply.getLkind() == 5){
                staffService.updateStaffHoliday(acquireLeaveApply.getLstaffId(),
                        (int) ( staffService.getSalaryHolidayById(acquireStaffId) + (acquireLeaveApply.getLstartTime().getTime()-acquireLeaveApply.getLendTime().getTime())/(Ms)));
            }
        }else {
            leaveApplyService.updateStatus(acquireApplyId, acquirePassStaffId,0/*database中的拒绝*/);
        }

        return new WebOperationResult(true,"Successfully check leave apply!");
    }

    @RequestMapping(value = "/vacation", produces = "application/json;charset=UTF-8")
    public loginInfo getVacation(@RequestBody Staff staff){
        String acquireStaffId = staff.getSid();
        return new loginInfo(acquireStaffId, staffService.getStaffPosition(acquireStaffId), staffService.getStaffDepartment(acquireStaffId), staffService.getSalaryHolidayById(acquireStaffId));
    }

}
