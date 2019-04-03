package com.mrqiu.webassignment.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DepartmentDao {

    @Select("select dname from department " +
            "where did = #{did}")
    String getDepartmentNameById(@Param("did") String departmentId);
}
