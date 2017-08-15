package com.company.examples.inharitence;

/**
 * Created by cic56 on 05.07.2017.
 */
public class Dragon extends Animal implements Fly,Swim{
    @Override
    void voice() {
        System.out.println("aaaaarrrrr");
    }

    @Override
    public void fly() {
        System.out.println("fly whith fire!");
    }

    @Override
    public void swim() {

    }
}
