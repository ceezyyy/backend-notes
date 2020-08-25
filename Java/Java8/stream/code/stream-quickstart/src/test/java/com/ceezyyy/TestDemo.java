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
public class TestDemo {

    private List<String> list = new ArrayList<>();

    @Before
    public void init() {
        list.add("LBJ");
        list.add("AD");
    }

    @Test
    public void testFilter() {
        list.stream().filter(s -> s.startsWith("L")).filter(s -> s.length() >= 3).forEach(System.out::println);  // LBJ
    }

    @Test
    public void testLimit() {
        list.stream().limit(2).forEach(System.out::println);  // LBJ AD
    }

    @Test
    public void testConcat() {
        Stream<String> limit = list.stream().limit(1);
        Stream<String> skip = list.stream().skip(1);
        Stream.concat(limit, skip).forEach(System.out::println);  // LBJ AD
    }

    @Test
    public void testSorted() {
        list.stream().sorted().forEach(System.out::println);  // AD LBJ
    }

    @Test
    public void testReverseSorted() {
        list.stream().sorted((s1, s2) ->


    }
