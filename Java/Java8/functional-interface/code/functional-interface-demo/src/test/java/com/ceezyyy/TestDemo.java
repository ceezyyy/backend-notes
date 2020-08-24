package com.ceezyyy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestDemo {

    @Test
    public void test() {
        MyInterface myInterface = () -> {
            log.info("myInterface here!");
        };

        myInterface.show();

    }

}
