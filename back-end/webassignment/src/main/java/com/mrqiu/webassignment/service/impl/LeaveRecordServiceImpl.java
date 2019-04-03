package com.mrqiu.webassignment.service.impl;

import com.mrqiu.webassignment.Exception.NoLeaveApplyException;
import com.mrqiu.webassignment.Exception.NoLeaveRecordException;
import com.mrqiu.webassignment.Exception.NoStaffException;
import com.mrqiu.webassignment.Exception.TimeException;
import com.mrqiu.webassignment.dao.LeaveApplyDao;
import com.mrqiu.webassignment.dao.LeaveRecordDao;
import com.mrqiu.webassignment.dao.StaffDao;
import com.mrqiu.webassignment.entity.LeaveApply;
import com.mrqiu.webassignment.entity.LeaveRecord;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.LeaveRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class LeaveRecordServiceImpl implements LeaveRecordService {

    @Resource
    private LeaveRecordDao leaveRecordDao;
    @Resource
    private LeaveApplyDao leaveApplyDao;
    @Resource
    private StaffDao staffDao;

    @Override
    public ArrayList<LeaveRecord> queryAllLeaveRecord() {
        return leaveRecordDao.queryAllLeaveRecord();
    }

    @Override
    public ArrayList<LeaveRecord> queryLeaveRecordByStaffId(String staffId) throws NoStaffException{
        Staff staff = staffDao.getStaffById(staffId);
        if (staff == null){
            throw new NoStaffException();
        }
        return leaveRecordDao.queryLeaveRecordByStaffId(staffId);
    }

    @Override
    public ArrayList<LeaveRecord> queryLeaveRecordByTime(Timestamp startTime, Timestamp endTime) throws TimeException{
        if (startTime.after(endTime)){
            throw new TimeException();
        }
        return leaveRecordDao.qeuryLeaveRecordByTime(startTime, endTime);
    }

    @Override
    @Transactional
    public Integer insertLeaveRecord(long leaveApplyId) throws NoLeaveApplyException{
        LeaveApply leaveApply = leaveApplyDao.queryLeaveApplyById(leaveApplyId);
        if (leaveApply == null){
            throw new NoLeaveApplyException();
        }
        try{
            leaveApplyDao.deleteLeaveApply(leaveApply.getLid());
        } catch (NoLeaveApplyException e1){
            throw e1;
        } catch (Exception e){
            throw e;
        }
        return leaveRecordDao.insertLeaveRecord(leaveApply.getLstaffId(),
                leaveApply.getLstartTime(), leaveApply.getLendTime(),
                leaveApply.getLreason(), leaveApply.getLkind(), leaveApply.getLpassStaffId());
    }

    @Override
    public Integer deleteLeaveRecord(long applyId) throws NoLeaveRecordException{
        LeaveRecord leaveRecord = leaveRecordDao.queryLeaveRecordById(applyId);
        if (leaveRecord == null){
            throw new NoLeaveRecordException();
        }
        return leaveRecordDao.deleteLeaveRecord(applyId);
    }
}