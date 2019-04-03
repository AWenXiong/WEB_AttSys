package com.mrqiu.webassignment.dao;

import com.mrqiu.webassignment.entity.OutApply;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface OutApplyDao {

    /**
     * 获取所有外出申请信息
     * @return
     */
    ArrayList<OutApply> queryAllOutApply();

    /**
     * 根据员工ID获取对应员工的外出申请信息
     * @param staffId
     * @return
     */
    ArrayList<OutApply> queryOutApplyByStaffId(@Param("staffId") String staffId);

    OutApply queryOutApplyById(@Param("outApplyId") long outApplyId);

    /**
     * 新增外出申请
     * @param staffId
     * @param startTime
     * @param endTime
     * @param reason
     * @return
     */
    Integer insertOutApply(@Param("staffId") String staffId,
                           @Param("startTime") Timestamp startTime,
                           @Param("endTime") Timestamp endTime,
                           @Param("reason") String reason);

    /**
     * 删除外出申请
     * @param applyId
     * @return
     */
    Integer deleteOutApply(@Param("applyId") long applyId);

    /**
     * 更新外出申请，更新批准人以及状态
     * @param oid
     * @param passStaffId
     * @param status
     * @return
     */
    Integer updateStatus(@Param("oid") long oid,
                         @Param("passStaffId") String passStaffId,
                         @Param("status") long status);

    @Update("update out_apply " +
            "set ostart_time = #{startTime}, oend_time = #{endTime}, oreason = #{reason}, " +
            "ostatus = 0 " +
            "where oid = #{oid}")
    Integer updateOutApply(@Param("oid") long lid,
                             @Param("startTime") Timestamp startTime,
                             @Param("endTime") Timestamp endTime,
                             @Param("reason") String reason);
}
