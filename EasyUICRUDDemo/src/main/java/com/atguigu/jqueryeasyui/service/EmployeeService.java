package com.atguigu.jqueryeasyui.service;

import com.atguigu.jqueryeasyui.bean.Employee;
import com.atguigu.jqueryeasyui.mappers.EmployeeMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmpList() {
        return employeeMapper.selectAll();
    }

    public void saveEmp(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void removeEmp(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
    }

    public List<Employee> getEmpListPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return employeeMapper.selectAll();
    }

}
