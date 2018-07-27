package com.atguigu.jqueryeasyui.controller;

import com.atguigu.jqueryeasyui.bean.Employee;
import com.atguigu.jqueryeasyui.service.EmployeeService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("/getEmpList")
    public Object getEmpList() {

        List<Employee> list = employeeService.getEmpList();

        HashMap<Object, Object> jsonMap = new HashMap<>();
        jsonMap.put("rows", list);

        return jsonMap;
    }

    @ResponseBody
    @RequestMapping("/saveEmp")
    public Object saveEmp(Employee employee) {
        employeeService.saveEmp(employee);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/removeEmp")
    public Object removeEmp(Integer empId) {

        Map<String, Object> map = new HashMap<>();

        try {
            employeeService.removeEmp(empId);

            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateEmp")
    public Object updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/getEmpListPage")
    public Object getEmpListPage(@RequestParam("page") Integer pageNo, @RequestParam("rows") Integer pageSize) {

        List<Employee> empList = employeeService.getEmpListPage(pageNo, pageSize);

        List<Employee> list = new ArrayList<>();

        Page<Employee> page = (Page<Employee>) empList;

        long total = page.getTotal();

        Map<String, Object> map = new HashMap<>();

        map.put("total", total);
        map.put("rows", empList);

        return map;
    }

}
