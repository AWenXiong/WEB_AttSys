package com.mrqiu.webassignment.dao;

import com.mrqiu.webassignment.entity.OutRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface OutRecordDao {

    @Select("select * from out_record")
    ArrayList<OutRecord> queryAllOutRecord();

    @Select("select * from out_record " +
            "where ostaff_id = #{staffId}")
    ArrayList<OutRecord> queryOutRecordByStaffId(@Param("staffId") String staffId);

    @Select("select * from out_record " +
            "where oid = #{applyId}")
    OutRecord queryOutRecordById(@Param("applyId") long applyId);

    @Select("select * from out_record " +
            "where ostart_time >= startTime and " +
            "oend_time <= endTime")
    ArrayList<OutRecord> qeuryOutRecordByTime(@Param("startTime") Timestamp startTime,
                                                  @Param("endTime") Timestamp endTime);

    @Insert("insert into out_record" +
            "(ostaff_id, ostart_time, oend_time, oreason, opass_staff_id) " +
            "value" +
            "(#{staffId}, #{startTime}, #{endTime}, #{reason}, #{passStaffId})")
    Integer insertOutRecord(@Param("staffId") String staffId,
                            @Param("startTime") Timestamp startTime,
                            @Param("endTime") Timestamp endTime,
                            @Param("reason") String reason,
                            @Param("passStaffId") String passStaffid);

    @Delete("delete from out_record " +
            "where oid = #{applyId}")
    Integer deleteOutRecord(@Param("applyId") long applyId);
}
