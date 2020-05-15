package com.ceezyyy.factory;

import com.ceezyyy.service.impl.UserServiceImpl;

public class TempFactory {
    public static Object getBean() {
        return new UserServiceImpl();
    }
}
