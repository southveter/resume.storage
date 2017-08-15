package com.company.examples.listarray;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cic56 on 14.06.2017.
 */
public class GetMapValues {
    public static void main(String[] args) {
         Map<String,Integer> map = new HashMap<>();
         map.put("Kollya",23);
         map.put("Vasia",23);
         map.put("Petya",23);
         map.put("Nikoddim",23);
        map.put("Niko",24);

        System.out.println(map);
        System.out.println(map.get("Nik"));
    }
}
