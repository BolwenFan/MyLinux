package com.atguigu.dubbo.bean;

import java.io.Serializable;

/**
 * @author unclefan
 * @create 2018-07-20 0:50
 */
public class Employee implements Serializable {
    private Integer id;
    private String name;

    public Employee() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(Integer id, String name) {

        this.id = id;
        this.name = name;
    }
}
