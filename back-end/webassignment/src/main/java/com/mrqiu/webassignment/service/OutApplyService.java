package com.mrqiu.webassignment.service;

import com.mrqiu.webassignment.entity.OutApply;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface OutApplyService {
    ArrayList<OutApply> queryAllOutApply();

    ArrayList<OutApply> queryOutApplyByStaffId(String staffId);

    Integer insertOutApply(String staffId,
                           Timestamp startTime,
                           Timestamp endTime,
                           String reason);

    Integer deleteOutApply(long applyId);

    Integer updateStatus(long applyId,
                         String passStaffId,
                         long status);

    Integer updateOutApply(long applyId,
                           Timestamp startTime,
                           Timestamp endTime,
                           String reason);
}
