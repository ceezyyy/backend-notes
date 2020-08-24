package com.ceezyyy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Demo for stream
 */
@Slf4j
public class TestDemo {

    private List<String> list = new ArrayList<>();

    @Before
    public void init() {
        list.add("LBJ");
        list.add("AD");
    }


    @Test
    public void testFilter() {
        list.stream().filter(s -> s.startsWith("L")).filter(s -> s.length() >=3).forEach(System.out::println);
    }


}
