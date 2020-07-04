package com.learnjava.www.behavioralPatterns.observer;

public class Main {
    public static void main(String[] args) {
        // observer:
        Admin a = new Admin();
        Customer c = new Customer();
// store:
        Store store = new Store();
// 注册观察者:
        store.addObserver(a);
        store.addObserver(c);
// 匿名扩充
        store.addObserver(new ProductObserver() {
            public void onPublished(Product product) {
                System.out.println("[Log] on product published: " + product);
            }

            public void onPriceChanged(Product product) {
                System.out.println("[Log] on product price changed: " + product);
            }
        });
    }
}
