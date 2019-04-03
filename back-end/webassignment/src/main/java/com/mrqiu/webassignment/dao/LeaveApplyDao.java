package com.mrqiu.webassignment.dao;

import com.mrqiu.webassignment.entity.LeaveApply;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface LeaveApplyDao {

    /**
     * 获取所有请假申请信息
     * @return
     */
    @Select("select * from leave_apply")
    ArrayList<LeaveApply> queryAllLeaveApply();

    /**
     * 通过员工ID获取对应员工的请假申请
     * @param staffId
     * @return
     */
    @Select("select * from leave_apply " +
            "where lstaff_id = #{staffId}")
    ArrayList<LeaveApply> queryLeaveApplyByStaffId(@Param("staffId") String staffId);

    /**
     * 根据请假申请Id获取对应的请假申请
     * @param leaveApplyId
     * @return
     */
    @Select("select * from leave_apply " +
            "where lid = #{leaveApplyId}")
    LeaveApply queryLeaveApplyById(@Param("leaveApplyId") long leaveApplyId);

    /**
     * 新增请假申请
     * @param staffId
     * @param startTime
     * @param endTime
     * @param reason
     * @param kind
     * @return
     */
    @Insert("insert into leave_apply(lstaff_id, lstart_time, lend_time, lreason, lkind, lstatus) " +
            "value(#{staffId},#{startTime},#{endTime},#{reason},#{kind}, 1)")
    Integer insertLeaveApply(@Param("staffId") String staffId,
                             @Param("startTime")Timestamp startTime,
                             @Param("endTime") Timestamp endTime,
                             @Param("reason") String reason,
                             @Param("kind") long kind);

    /**
     * 删除请假申请
     * @param applyId
     * @return
     */
    @Delete("delete from leave_apply " +
            "where lid = #{applyId}")
    Integer deleteLeaveApply(@Param("applyId") long applyId);

    /**
     * 更新请假申请，更新批准人以及状态
     * @param lid
     * @param passStaffId
     * @param status
     * @return
     */
    @Update("update leave_apply " +
            "set lpass_staff_id = #{passStaffId}, lstatus = #{status} " +
            "where lid = #{lid}")
    Integer updateStatus(@Param("lid") long lid,
                         @Param("passStaffId") String passStaffId,
                         @Param("status") long status);

    @Update("update leave_apply " +
            "set lstart_time = #{startTime}, lend_time = #{endTime}, lkind = #{kind}, lreason = #{reason}, " +
            "lstatus = 0 " +
            "where lid = #{lid}")
    Integer updateLeaveApply(@Param("lid") long lid,
                             @Param("startTime") Timestamp startTime,
                             @Param("endTime") Timestamp endTime,
                             @Param("kind") long kind,
                             @Param("reason") String reason);
}
