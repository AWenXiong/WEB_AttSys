package com.mrqiu.webassignment.dao;

import com.mrqiu.webassignment.entity.LeaveRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface LeaveRecordDao {

    @Select("select * from leave_record")
    ArrayList<LeaveRecord> queryAllLeaveRecord();

    @Select("select * from leave_record " +
            "where lstaff_id = #{staffId}")
    ArrayList<LeaveRecord> queryLeaveRecordByStaffId(@Param("staffId") String staffId);

    @Select("select * from leave_record " +
            "where lid = #{lid}")
    LeaveRecord queryLeaveRecordById(@Param("lid") long lid);

    @Select("select * from leave_record " +
            "where lstart_time >= startTime and " +
            "lend_time <= endTime")
    ArrayList<LeaveRecord> qeuryLeaveRecordByTime(@Param("startTime") Timestamp startTime,
                                                  @Param("endTime") Timestamp endTime);

    @Insert("insert into leave_record" +
            "(lstaff_id, lstart_time, lend_time, lreason, lkind, lpass_staff_id) " +
            "value" +
            "(#{staffId}, #{startTime}, #{endTime}, #{reason}, #{kind}, #{passStaffId})")
    Integer insertLeaveRecord(@Param("staffId") String staffId,
                              @Param("startTime") Timestamp startTime,
                              @Param("endTime") Timestamp endTime,
                              @Param("reason") String reason,
                              @Param("kind") long kind,
                              @Param("passStaffId") String passStaffId);

    @Delete("delete from leave_record " +
            "where lid = #{applyId}")
    Integer deleteLeaveRecord(@Param("applyId") long applyId);

}
