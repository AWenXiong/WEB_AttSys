package com.mrqiu.webassignment.service;

import com.mrqiu.webassignment.entity.LeaveApply;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface LeaveApplyService {

    /**
     * 查询所有的请假申请
     * @return
     */
    ArrayList<LeaveApply> queryAllLeaveApply();

    /**
     * 根据员工Id查询该名员工的请假申请
     * @param staffId
     * @return
     */
    ArrayList<LeaveApply> queryLeaveApplyByStaffId(String staffId);

    /**
     * 新增请假申请
     * @param staffId
     * @param startTime
     * @param endTime
     * @param reason
     * @param kind
     * @return
     */
    Integer insertLeaveApply(String staffId,
                             Timestamp startTime,
                             Timestamp endTime,
                             String reason,
                             long kind);

    /**
     * 根据请假申请的Id删除请假申请
     * @param applyId
     * @return
     */
    Integer deleteLeaveApply(long applyId);

    /**
     * 更新请假申请的状态以及审批人
     * @param applyId
     * @param passStaffId
     * @param status
     * @return
     */
    Integer updateStatus(long applyId, String passStaffId, long status);

    Integer updateLeaveApply(long applyId,
                             Timestamp startTime,
                             Timestamp endTime,
                             String reason,
                             long kind);

    String queryStaffIdByLeaveId(long applyId);

    LeaveApply qureyLeaveApplyByApplyId(long applyId);
}
