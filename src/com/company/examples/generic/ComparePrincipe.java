package com.company.examples.generic;

import com.company.model.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cic56 on 26.06.2017.
 */
public class ComparePrincipe {
    public static void main(String[] args) {
        String s = "1";
        String s1 = "1";
        //System.out.println(s1.compareTo(s));
        Map<Integer, Resume> examle = new TreeMap<>();
        for (int i = 0; i < 100; i++) {
            examle.put(i, new Resume("Name" +i));
        }
        System.out.println(examle);
    }
}
