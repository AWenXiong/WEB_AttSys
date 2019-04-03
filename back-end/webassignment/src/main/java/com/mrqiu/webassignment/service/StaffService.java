package com.mrqiu.webassignment.service;

import com.mrqiu.webassignment.entity.Staff;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface StaffService {
    /**
     * 身份验证
     * @param userName
     * @param password
     * @return 与用户名和密码相匹配的用户id
     */
    String checkStaff(String userName, String password);

    /**
     * 获取员工名字
     * 展示全体员工请假及外出信息
     * @param staffId
     * @return
     */
    String  getStaffName(String staffId);

    /**
     * 通过id获取员工性别
     * @param staffId
     * @return
     */
    String getStaffGender(String staffId);

    /**
     * 通过id获取员工所属部门id
     * @param staffId
     * @return
     */
    String getStaffDepartment(String staffId);

    /**
     * 通过员工id获取员工职位
     * @param staffId
     * @return
     */
    String getStaffPosition(String staffId);

    /**
     * 通过员工id获取员工联系方式
     * @param staffId
     * @return
     */
    String getStaffContact(String staffId);

    /**
     * 根据员工id获取员工住址
     * @param staffId
     * @return
     */
    String getStaffAddress(String staffId);

    /**
     * 通过员工id获取员工可休年假天数
     * @param staffId
     * @return
     */
    int getSalaryHolidayById(String staffId);

    /**
     * 根据员工id获取入职时间
     * @param staffId
     * @return
     */
    Timestamp getEntryTime(String staffId);

    /**
     * 根据员工id获取员工对象
     * @param staffId
     * @return
     */
    Staff getStaffById(String staffId);

    /**
     * 获取全部员工对象
     * @return
     */
    ArrayList<Staff> getAllStaff();

    /**
     * 新增员工
     * @param sid 员工id
     * @param saccount 账号
     * @param spassword 密码
     * @param sname 姓名
     * @param sgender 性别
     * @param sdid 部门id
     * @param sposition 职位
     * @param scontact 联系方式
     * @param saddress 地址
     * @param sentryTime 入职时间
     * @param ssalaryHoliday 可休年假时间
     * @return
     */
    Integer insertStaff(String sid, String saccount, String spassword, String sname
            , String sgender, String sdid, String sposition, String scontact, String saddress,
                        Timestamp sentryTime, int ssalaryHoliday);

    /**
     * 通过id删除员工
     * @param staffId
     * @return
     */
    Integer deleteStaff(String staffId);

    /**
     * 通过id更新员工信息
     * @param sid
     * @param saccount
     * @param spassword
     * @param sname
     * @param sgender
     * @param sdid
     * @param sposition
     * @param scontact
     * @param saddress
     * @param sentryTime
     * @param ssalaryHoliday
     * @return
     */
    Integer updateStaff(String sid, String saccount, String spassword, String sname
            , String sgender, String sdid, String sposition, String scontact, String saddress,
                        Timestamp sentryTime, int ssalaryHoliday);

    /**
     * 设置/修改员工可休年假天数
     * @param staffId
     * @param salaryHoliday
     * @return
     */
    Integer updateStaffHoliday(String staffId, int salaryHoliday);
}
