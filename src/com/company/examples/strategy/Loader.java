package com.company.examples.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;

/**
 * Created by cic56 on 12.06.2017.
 */
public class Loader {
    public static void main(String[] args) throws IOException {
        Encryption encryption = new Encryption(new DESAlgorithm());
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\1.txt"));
        System.out.println(bufferedReader.read());
    }
}
