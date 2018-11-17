package com.itserver;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
    private String pname;
    private String[] arrs;

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private List list;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    private Map map;
    private Properties properties;

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void test() {
        System.out.println("test.........." + pname);
        System.out.println(list);
        System.out.println(map);
        System.out.println(arrs);
        System.out.println(properties);
    }
}
