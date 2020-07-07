package com.learnjava.www.structPatterns.flyweight;

public class Main {
    public static void main(String[] args) {
        Integer n1 = Integer.valueOf(100);
        Integer n2 = Integer.valueOf(100);
        System.out.println(n1 == n2); // true


        var std1 = Student.create(1111, "John");
        var std2 = Student.create(2222, "Jame");
        var std3 = Student.create(1111, "John");

        System.out.println(std1 == std3);
    }
}
