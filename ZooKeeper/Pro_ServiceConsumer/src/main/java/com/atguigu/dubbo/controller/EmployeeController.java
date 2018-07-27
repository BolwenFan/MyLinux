package com.atguigu.dubbo.controller;

import com.atguigu.dubbo.bean.Employee;
import com.atguigu.dubbo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author unclefan
 * @create 2018-07-20 1:17
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/index")
    public String index(Employee employee, Model model) {
        Employee result = employeeService.updateEmp(employee);
        model.addAttribute("result", result);
        return "index";
    }
}
