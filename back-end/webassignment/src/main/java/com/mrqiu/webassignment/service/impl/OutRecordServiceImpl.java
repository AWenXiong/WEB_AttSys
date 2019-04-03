package com.mrqiu.webassignment.service.impl;

import com.mrqiu.webassignment.Exception.NoOutApplyException;
import com.mrqiu.webassignment.Exception.NoOutRecordException;
import com.mrqiu.webassignment.Exception.NoStaffException;
import com.mrqiu.webassignment.Exception.TimeException;
import com.mrqiu.webassignment.dao.OutApplyDao;
import com.mrqiu.webassignment.dao.OutRecordDao;
import com.mrqiu.webassignment.dao.StaffDao;
import com.mrqiu.webassignment.entity.OutApply;
import com.mrqiu.webassignment.entity.OutRecord;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.OutRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public class OutRecordServiceImpl implements OutRecordService {

    @Resource
    private OutRecordDao outRecordDao;
    @Resource
    private OutApplyDao outApplyDao;
    @Resource
    private StaffDao staffDao;

    @Override
    public ArrayList<OutRecord> queryAllOutRecord() {
        return outRecordDao.queryAllOutRecord();
    }

    @Override
    public ArrayList<OutRecord> queryOutRecordByStaffId(String staffId) throws NoStaffException{
        Staff staff = staffDao.getStaffById(staffId);
        if (staff == null){
            throw new NoStaffException();
        }
        return outRecordDao.queryOutRecordByStaffId(staffId);
    }

    @Override
    public ArrayList<OutRecord> queryOutRecordByTime(Timestamp startTime, Timestamp endTime) throws TimeException {
        if (startTime.after(endTime)){
            throw new TimeException();
        }
        return outRecordDao.qeuryOutRecordByTime(startTime, endTime);
    }

    @Override
    @Transactional
    public Integer insertOutRecord(long outApplyId) throws NoOutApplyException{
        OutApply outApply = outApplyDao.queryOutApplyById(outApplyId);
        if (outApply == null){
            throw new NoOutApplyException();
        }
        try{
            outApplyDao.deleteOutApply(outApplyId);
        } catch (NoOutApplyException e1){
            throw e1;
        } catch (Exception e){
            throw e;
        }
        return outRecordDao.insertOutRecord(outApply.getOstaffId(),
                outApply.getOstartTime(), outApply.getOendTime(),
                outApply.getOreason(), outApply.getOpassStaffId());
    }

    @Override
    public Integer deleteOutRecord(long applyId) throws NoOutApplyException{
        OutRecord outRecord = outRecordDao.queryOutRecordById(applyId);
        if (outRecord == null){
            throw new NoOutRecordException();
        }
        return outApplyDao.deleteOutApply(applyId);
    }
}
