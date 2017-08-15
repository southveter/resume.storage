package com.company.examples.dot3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cic56 on 14.07.2017.
 */
public class Loader {
    public static void main(String[] args) {
//        String[] wrds = {"mom", "wosh", "ram"};
//        List<String> words = Arrays.asList(wrds);
//        PrintClass printClass = new PrintClass(words);
        PrintClass printClass1 = new PrintClass("mom", "wosh", "ram", "lima");
        System.out.println(printClass1.toString());
    }
}
