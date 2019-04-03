package com.mrqiu.webassignment.service.impl;

import com.mrqiu.webassignment.Exception.*;
import com.mrqiu.webassignment.dao.LeaveApplyDao;
import com.mrqiu.webassignment.dao.StaffDao;
import com.mrqiu.webassignment.entity.LeaveApply;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.LeaveApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class LeaveApplyServiceImpl implements LeaveApplyService {

    @Resource
    private LeaveApplyDao leaveApplyDao;
    @Resource
    private StaffDao staffDao;

    @Override
    public ArrayList<LeaveApply> queryAllLeaveApply() {
        return leaveApplyDao.queryAllLeaveApply();
    }

    @Override
    public ArrayList<LeaveApply> queryLeaveApplyByStaffId(String staffId) throws NoStaffException{
        Staff staff = staffDao.getStaffById(staffId);
        if (staff == null){
            System.out.println("NoStaffException");
            throw new NoStaffException();
        }
        return leaveApplyDao.queryLeaveApplyByStaffId(staffId);
    }

    @Override
    public Integer insertLeaveApply(String staffId,
                                    Timestamp startTime,
                                    Timestamp endTime,
                                    String reason,
                                    long kind) throws TimeException, NoStaffException, PriorityException, LeaveKindException{
        Staff staff = staffDao.getStaffById(staffId);
        if (startTime.after(endTime)){
            throw new TimeException();
        }
        if (staff == null){
            throw new NoStaffException();
        }
        if (kind < 0 || kind > 7){
            throw new LeaveKindException();
        }

        return leaveApplyDao.insertLeaveApply(staffId, startTime, endTime, reason, kind);
    }

    @Override
    public Integer deleteLeaveApply(long applyId) throws NoLeaveApplyException {
        LeaveApply leaveApply = leaveApplyDao.queryLeaveApplyById(applyId);
        if (leaveApply == null){
            throw new NoLeaveApplyException();
        }
        return leaveApplyDao.deleteLeaveApply(applyId);
    }

    @Override
    public Integer updateStatus(long applyId,
                                String passStaffId,
                                long status) throws NoLeaveApplyException, NoStaffException, StatusException{
        LeaveApply leaveApply = leaveApplyDao.queryLeaveApplyById(applyId);
        Staff staff = staffDao.getStaffById(passStaffId);
        if (leaveApply == null){
            throw new NoLeaveApplyException();
        }
        if (staff == null){
            throw new NoStaffException();
        }
        return leaveApplyDao.updateStatus(applyId, passStaffId, status);
    }

    @Override
    public Integer updateLeaveApply(long applyId,
                                    Timestamp startTime,
                                    Timestamp endTime,
                                    String reason,
                                    long kind) throws NoLeaveApplyException, TimeException, LeaveKindException{
        LeaveApply leaveApply = leaveApplyDao.queryLeaveApplyById(applyId);
        if (leaveApply == null){
            throw new NoLeaveApplyException();
        }
        if (startTime.after(endTime)){
            throw new TimeException();
        }
        if (kind < 0 || kind > 7){
            throw new LeaveKindException();
        }
        if(leaveApply.getLstatus() == 0){
            leaveApplyDao.updateStatus(applyId, leaveApply.getLpassStaffId(), 1);
        }
        return leaveApplyDao.updateLeaveApply(applyId, startTime, endTime, kind, reason);
    }

    @Override
    public String queryStaffIdByLeaveId(long applyId){
        LeaveApply leaveApply = leaveApplyDao.queryLeaveApplyById(applyId);
        return leaveApply.getLstaffId();
    }

    @Override
    public LeaveApply qureyLeaveApplyByApplyId(long applyId) {
        return leaveApplyDao.queryLeaveApplyById(applyId);
    }

}
