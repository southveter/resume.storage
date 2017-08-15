package com.company.examples;



/**
 * Created by cic56 on 12.06.2017.
 */
public class Cat extends Pet{
    static {
        System.out.println("lalala");
    }
    public Cat() {
        System.out.println("I am cat!");
    }

    static class Kitty{
        private double weight;
         public Kitty() {
            System.out.println("i am kitty!");
            weight = 0;
         }
    }
}
