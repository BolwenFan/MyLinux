package com.atguigu.jqueryeasyui.mappers;

import com.atguigu.jqueryeasyui.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test() {
        for (int i = 0; i < 100; i++) {
            employeeMapper.insertSelective(new Employee(null, "emp" + (i + 99), i + 9.0, i));

        }
    }


}