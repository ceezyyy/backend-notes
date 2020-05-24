package com.ceezyyy.entity;

import java.util.List;
import java.util.Map;

public class Company {
    private String companyName;
    private String location;
    private String type;
    private Map<String, Account> accountMap;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", accountMap=" + accountMap +
                '}';
    }
}
