package com.ceezyyy.domain;

import java.io.Serializable;
import java.util.List;

public class RoleAndUser implements Serializable {
    private Integer uid;
    private Integer rid;

    public RoleAndUser() {
    }

    public RoleAndUser(Integer uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
