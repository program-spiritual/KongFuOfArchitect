package com.learnjava.www.behavioralPatterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store implements ProductObservable {

  private List<ProductObserver> observers = new ArrayList<>();

  private Map<String, Product> products = new HashMap<>();

  // 注册观察者:

  public void addObserver(ProductObserver observer) {
    this.observers.add(observer);
  }

  // 取消注册:

  public void removeObserver(ProductObserver observer) {
    this.observers.remove(observer);
  }

  public void addNewProduct(String name, double price) {
    Product p = new Product(name, price);

    products.put(p.getName(), p);

    // 通知观察者:

    observers.forEach(o -> o.onPublished(p));
  }

  public void setProductPrice(String name, double price) {
    Product p = products.get(name);

    p.setPrice(price);

    // 通知观察者:

    observers.forEach(o -> o.onPriceChanged(p));
  }
}
