package com.datababy.enity;

import java.io.Serializable;

/**
 * Created by yongma on 2017/1/26.
 */
public class Test implements Serializable {

    private String name;
    private String sex;

    public Test(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
