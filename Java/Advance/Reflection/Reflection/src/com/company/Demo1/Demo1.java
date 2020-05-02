package com.company.Demo1;

import com.company.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo1 {
    Person person = new Person();
    // 获取 Class 类对象
    Class personClass = person.getClass();

    @Test
    public void test() {
        // Fields
        Field[] fields = personClass.getFields();
        Field[] declaredFields = personClass.getDeclaredFields();

        try {
            // 获取 id 的 Field 对象
            Field id = personClass.getField("id");

            id.set(person, 100);
            Object o = id.get(person);
            System.out.println(o);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        try {
            Constructor constructor = personClass.getConstructor(Integer.class, String.class, Integer.class,
                    String.class);
            Object o = constructor.newInstance(666, "Mike", 22, "male");
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            Method eat = personClass.getMethod("eat");
            eat.invoke(person);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
