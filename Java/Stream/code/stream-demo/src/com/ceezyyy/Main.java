package com.ceezyyy;

import java.util.ArrayList;
import java.util.List;

import static com.ceezyyy.Gender.*;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("AD", 12, MALE.name()));
        personList.add(new Person("LBJ", 22, MALE.name()));
        personList.add(new Person("DW", 32, FEMALE));
        personList.add(new Person("PG", 43, FEMALE));

        for (Person person : personList) {
            System.out.println(person);
        }

    }
}
