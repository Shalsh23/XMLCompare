package com.mycompany.app;

import java.lang.*;
import java.net.URL;

public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {

        Class cls = Class.forName("ClassLoaderDemo");

        // returns the ClassLoader object associated with this Class
        ClassLoader cLoader = cls.getClassLoader();

        System.out.println(cLoader.getClass());

        // finds resource with the given name
        URL url = cLoader.getResource("file.txt");
        System.out.println("Value = " + url);

        // finds resource with the given name
        url = cLoader.getResource("newfolder/a.txt");
        System.out.println("Value = " + url);
    }
}