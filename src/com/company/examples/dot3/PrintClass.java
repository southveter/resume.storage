package com.company.examples.dot3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cic56 on 14.07.2017.
 */
public class PrintClass {
    private List <String> words;

    public PrintClass(List<String> words) {
        this.words = words;
    }

    public PrintClass(String... wrds) {
        this(Arrays.asList(wrds));
       // words = Arrays.asList(wrds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <words.size() ; i++) {
            sb.append(words.get(i) + "\n");
        }
        return sb.toString();
    }
}
