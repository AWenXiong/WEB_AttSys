package com.mrqiu.webassignment.service;

import com.mrqiu.webassignment.entity.LeaveRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public interface LeaveRecordService {

    /**
     * 查询所有的请假记录
     * @return
     */
    ArrayList<LeaveRecord> queryAllLeaveRecord();

    /**
     * 根据员工Id查询该名员工的请假记录
     * @param staffId
     * @return
     */
    ArrayList<LeaveRecord> queryLeaveRecordByStaffId(String staffId);


    /**
     * 根据时间范围查询所有员工的请假记录
     * @param startTime
     * @param endTime
     * @return
     */
    ArrayList<LeaveRecord> queryLeaveRecordByTime(Timestamp startTime, Timestamp endTime);

    /**
     * 根据请假申请的Id新增请假记录
     * @return
     */
    @Transactional
    Integer insertLeaveRecord(long leaveApplyId);

    /**
     * 删除请假记录
     * @param applyId
     * @return
     */
    Integer deleteLeaveRecord(long applyId);
}
