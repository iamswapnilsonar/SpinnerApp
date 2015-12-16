package com.example;

import java.awt.Rectangle;

public class MyClass {

    public static void main(String[] args) throws Exception {

        Rectangle rectangle = new Rectangle(11, 313, 30, 30);
        boolean value = rectangle.contains(40, 342);
        String message = value ? "Point contains in rectangle" : "Point not contains in rectangle";
        System.out.println(message);
    }

}
