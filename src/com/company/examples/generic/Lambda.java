package com.company.examples.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cic56 on 21.06.2017.
 */
public class Lambda {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5,6);
        for (int num:number) {
            System.out.println(num);
        }
        number.forEach((Integer value) -> System.out.println(value));
    }
}
