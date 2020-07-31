package com.ceezyyy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.ceezyyy.Gender.*;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("AD", 12, MALE.name()));
        personList.add(new Person("LBJ", 22, MALE.name()));
        personList.add(new Person("DW", 32, FEMALE.name()));
        personList.add(new Person("PG", 43, FEMALE.name()));

        List<Person> females = personList.stream()
                .filter(person -> person.getGender().equals(FEMALE.name()))
                .collect(Collectors.toList());

        females.forEach(System.out::println);

    }
}
