package com.learnjava.www.behavioralPatterns.observer;

public class Product {

    double price;

    String name;

    public Product(String name, double price) {

        this.price = price;

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
