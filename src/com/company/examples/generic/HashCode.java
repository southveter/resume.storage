package com.company.examples.generic;

import com.company.model.Link;

/**
 * Created by cic56 on 23.06.2017.
 */
public class HashCode {
    public static void main(String[] args) {
        Link link = new Link("s","s");
        Link link1 = new Link("s","s");
        System.out.println(link.hashCode());
        System.out.println(link.equals(link1));
    }
}
