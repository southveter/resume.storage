package com.company.examples.generic;

/**
 * Created by cic56 on 21.06.2017.
 */
public class SingletonExample {
    private  static  SingletonExample instance;

    public  static  SingletonExample getInstance(){
        if(instance == null){
            instance = new SingletonExample();
        }
        return instance;
    }

    public static void main(String[] args) {



    }
}
