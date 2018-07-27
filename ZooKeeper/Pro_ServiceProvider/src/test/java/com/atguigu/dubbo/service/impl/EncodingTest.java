package com.atguigu.dubbo.service.impl;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author unclefan
 * @create 2018-07-20 1:11
 */
public class EncodingTest {

    @Test
    public void test() throws UnsupportedEncodingException {

        String s = "dubbo%3A%2F%2F192.168.27.1%3A20880%2Fcom.atguigu.dubbo.service.EmployeeService%3Fanyhost%3Dtrue%26application%3Demp_provider%26dubbo%3D2.5.5%26generic%3Dfalse%26interface%3Dcom.atguigu.dubbo.service.EmployeeService%26methods%3DupdateEmp%26pid%3D15940%26revision%3D1.0-SNAPSHOT%26side%3Dprovider%26timestamp%3D1532020157158";
        String encode = URLDecoder.decode(s, "UTF-8");
        System.out.println(encode);
    }
}
