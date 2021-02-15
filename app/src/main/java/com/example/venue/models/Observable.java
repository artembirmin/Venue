package com.example.venue.models;

import java.util.ArrayList;

public class Observable<T> {

    private ArrayList<Subscriber<T>> subscribers;

    public void subscribe(Subscriber<T> subscriber) {
        subscribers.add(subscriber);
    }

    public void notifySubscribers(T newValue){
        for (Subscriber<T> subscriber : subscribers) {
            subscriber.update(newValue);
        }
    }
}
