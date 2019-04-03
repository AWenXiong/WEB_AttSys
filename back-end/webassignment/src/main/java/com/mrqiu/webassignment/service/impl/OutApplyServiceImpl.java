package com.mrqiu.webassignment.service.impl;

import com.mrqiu.webassignment.Exception.*;
import com.mrqiu.webassignment.dao.OutApplyDao;
import com.mrqiu.webassignment.dao.StaffDao;
import com.mrqiu.webassignment.entity.LeaveApply;
import com.mrqiu.webassignment.entity.OutApply;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.OutApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class OutApplyServiceImpl implements OutApplyService {

    @Resource
    private OutApplyDao outApplyDao;
    @Resource
    private StaffDao staffDao;

    @Override
    public ArrayList<OutApply> queryAllOutApply() {
        return outApplyDao.queryAllOutApply();
    }

    @Override
    public ArrayList<OutApply> queryOutApplyByStaffId(String staffId) {
        Staff staff = staffDao.getStaffById(staffId);
        if (staff == null){
            throw new NoStaffException();
        }
        return outApplyDao.queryOutApplyByStaffId(staffId);
    }

    @Override
    public Integer insertOutApply(String staffId,
                                  Timestamp startTime,
                                  Timestamp endTime,
                                  String reason) throws TimeException, NoStaffException, PriorityException{
        Staff staff = staffDao.getStaffById(staffId);
        if (startTime.after(endTime)){
            throw new TimeException();
        }
        if (staff == null){
            throw new NoStaffException();
        }
        return outApplyDao.insertOutApply(staffId, startTime, endTime, reason);
    }

    @Override
    public Integer deleteOutApply(long applyId) throws NoOutApplyException{
        OutApply outApply = outApplyDao.queryOutApplyById(applyId);
        if (outApply == null){
            throw new NoOutApplyException();
        }

        return outApplyDao.deleteOutApply(applyId);
    }

    @Override
    public Integer updateStatus(long applyId, String passStaffId, long status)
            throws NoOutApplyException, NoStaffException, StatusException{
        OutApply outApply = outApplyDao.queryOutApplyById(applyId);
        Staff staff = staffDao.getStaffById(passStaffId);
        if (outApply == null){
            throw new NoOutApplyException();
        }
        if (staff == null){
            throw new NoStaffException();
        }
        if (status < 0 || status > 4){
            throw new StatusException();
        }
        return outApplyDao.updateStatus(applyId, passStaffId, status);
    }

    @Override
    public Integer updateOutApply(long applyId,
                                    Timestamp startTime,
                                    Timestamp endTime,
                                    String reason) throws NoLeaveApplyException, TimeException {
        OutApply outApply = outApplyDao.queryOutApplyById(applyId);
        if (outApply == null) {
            throw new NoLeaveApplyException();
        }
        if (startTime.after(endTime)) {
            throw new TimeException();
        }
        if(outApply.getOstatus() == 0){
            outApplyDao.updateStatus(applyId, outApply.getOpassStaffId(), 1);
        }
        return outApplyDao.updateOutApply(applyId, startTime, endTime, reason);
    }
}
