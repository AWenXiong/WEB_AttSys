package com.mrqiu.webassignment.controller;

import com.mrqiu.webassignment.dto.WebOperationResult;
import com.mrqiu.webassignment.entity.OutApply;
import com.mrqiu.webassignment.entity.Staff;
import com.mrqiu.webassignment.service.OutApplyService;
import com.mrqiu.webassignment.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.UUID;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private OutApplyService outApplyService;
    @Resource
    private StaffService staffService;

    @RequestMapping(value = "/",produces = "application/json;charset=UTF-8")
    public Staff testControllertesttesttest(@RequestBody Staff staff){
        return staffService.getStaffById(staff.getSid());
    }

    @RequestMapping(value = "/1")
    public String testController1(){
        System.out.println("1212121212");
        return "1212121212";
    }

    @RequestMapping(value = "/2", produces = "application/json;charset=UTF-8")
    public WebOperationResult testController2(){
        System.out.println("2");
        return new WebOperationResult(true, "MrBall");
    }

    @RequestMapping("/loggertest")
    public String loggerTestController(){
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "Dolly";
        String str2 = "Belu";
        logger.info("======str1：{}；str2：{}", str1, str2);

        return "Logger Test";
    }

    @RequestMapping("/queryall")
    public ArrayList<OutApply> OutApplyDaoTest_queryAll(){
        return outApplyService.queryAllOutApply();
    }

    @RequestMapping("/uuid")
    public int uuidTest(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase().length();
    }
}
