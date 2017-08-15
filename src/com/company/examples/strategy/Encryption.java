package com.company.examples.strategy;

/**
 * Created by cic56 on 12.06.2017.
 */
public class Encryption {

    private  Algorithm algorithm;

    public Encryption(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    public String crypt(String text, String key){
        return algorithm.crypt(text,key);
    }

}
