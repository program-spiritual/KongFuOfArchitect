package com.learnjava.www.behavioralPatterns.observer;

public interface ProductObserver {
    void onPublished(Product p);

    void onPriceChanged(Product p);
}
