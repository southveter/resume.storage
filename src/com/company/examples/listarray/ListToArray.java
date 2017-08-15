package com.company.examples.listarray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cic56 on 14.06.2017.
 */
public class ListToArray {
    public static void main(String[] args) {
        String[] s = {"red","orange","yellow"};
        List<String> rainbow= new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            rainbow.add(s[i]);
        }
        System.out.println(rainbow);
        Object[] ss =  rainbow.toArray();
        for (int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]  + " ");
        }
    }

}
