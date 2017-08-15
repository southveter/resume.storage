package com.company.examples.FileSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cic56 on 23.06.2017.
 */
public class Files {
    public static void main(String[] args) {
        String filepath = "";
        File file = new File(filepath);
        System.out.println(filepath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Err",e);
        }

        File dir = new File(filepath+"\\");
        System.out.println(dir.isDirectory());
        String[] dirFiles  = dir.list();
//        ArrayList<String> df = new ArrayList<>();
//        for (int i = 0; i < dirFiles.length; i++) {
//            System.out.println(dirFiles[i]);
//            df.add(dirFiles[i]);
//        }
//        System.out.println(df);
        printDirectoryDeeply(dir);

    }
    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }
}
