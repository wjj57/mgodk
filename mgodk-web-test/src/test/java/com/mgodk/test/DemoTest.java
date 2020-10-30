package com.mgodk.test;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DemoTest {
    @Test
    public void test() {
        String str = "asdfzxvqwer";
//        String[] s = str.split("");
//        for (String a : s) {
//            System.out.println(a);
//        }
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("");

//        long start = System.currentTimeMillis();
//        while (str.contains("df")) {
//            str = str.replace("df", "cc");
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(str);
//        long newEnd = System.currentTimeMillis();
//        System.out.println(end - start);
//        System.out.println(new Date());

        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("yyyy/MM/dd HH:mm:ss"));
    }
}
