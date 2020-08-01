package com.ceezyyy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ceezyyy.Gender.*;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("AD", 12, MALE.name()));
        personList.add(new Person("LBJ", 22, MALE.name()));
        personList.add(new Person("DW", 32, FEMALE.name()));
        personList.add(new Person("PG", 43, FEMALE.name()));


//        List<Person> females = personList.stream()
//                .filter(person -> person.getGender().equals(FEMALE.name()))
//                .collect(Collectors.toList());
//
//        females.forEach(System.out::println);


//        List<Person> sorted = personList.stream()
//                .sorted(Comparator.comparing(Person::getAge).reversed())
//                .collect(Collectors.toList());
//
//        sorted.forEach(System.out::println);

//        boolean allMatch = personList.stream()
//                .allMatch(person -> person.getGender().equals(FEMALE.name()));
//
//        System.out.println(allMatch);

//        boolean noneMatch = personList.stream()
//                .noneMatch(person -> person.getAge() <= 10);
//
//        System.out.println(noneMatch);


//        personList.stream()
//                .max(Comparator.comparing(Person::getAge))
//                .ifPresent(System.out::println);

        Map<String, List<Person>> genderGroup = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        genderGroup.forEach((s, people) -> {
            System.out.println(s);
            people.forEach(person -> {
                System.out.println(person);
            });
        });





    }
}
