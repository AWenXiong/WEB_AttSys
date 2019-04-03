package com.mrqiu.webassignment.service;

import com.mrqiu.webassignment.entity.OutRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public interface OutRecordService {

    /**
     * 查询所有的外出记录
     * @return
     */
    ArrayList<OutRecord> queryAllOutRecord();

    /**
     * 根据员工Id查询该名员工的外出记录
     * @param staffId
     * @return
     */
    ArrayList<OutRecord> queryOutRecordByStaffId(String staffId);


    /**
     * 根据时间范围查询所有员工的外出记录
     * @param startTime
     * @param endTime
     * @return
     */
    ArrayList<OutRecord> queryOutRecordByTime(Timestamp startTime, Timestamp endTime);

    /**
     * 根据外出申请的申请Id新增外出记录
     * @return
     */
    @Transactional
    Integer insertOutRecord(long outApplyId);

    /**
     * 删除外出记录
     * @param applyId
     * @return
     */
    Integer deleteOutRecord(long applyId);
}
