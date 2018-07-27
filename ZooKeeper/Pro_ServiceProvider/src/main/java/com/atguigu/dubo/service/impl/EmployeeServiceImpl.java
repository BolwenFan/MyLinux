package com.atguigu.dubo.service.impl;

import com.atguigu.dubbo.bean.Employee;
import com.atguigu.dubbo.service.EmployeeService;

/**
 * @author unclefan
 * @create 2018-07-20 0:57
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee updateEmp(Employee employee) {
        employee.setName(employee.getName()+"newname");
        return employee;
    }
}
