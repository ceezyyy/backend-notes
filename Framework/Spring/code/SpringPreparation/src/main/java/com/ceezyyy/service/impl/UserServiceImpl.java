package com.ceezyyy.service.impl;


import com.ceezyyy.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {
    private String a;
    private Integer b;
    private Date c;
    private List<Integer> list;
    private Set<Integer> set;
    private Map<Integer, String> map;


    public void setA(String a) {
        this.a = a;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public void setC(Date c) {
        this.c = c;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }


    public void save() {
        System.out.println("Saved");
    }

    public String getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public Date getC() {
        return c;
    }

    public List<Integer> getList() {
        return list;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                '}';
    }
}
