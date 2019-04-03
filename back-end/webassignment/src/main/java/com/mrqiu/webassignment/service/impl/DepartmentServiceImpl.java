package com.mrqiu.webassignment.service.impl;

import com.mrqiu.webassignment.dao.DepartmentDao;
import com.mrqiu.webassignment.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Override
    public String getDepartmentNameById(String departmentId) {
        return departmentDao.getDepartmentNameById(departmentId);
    }
}
