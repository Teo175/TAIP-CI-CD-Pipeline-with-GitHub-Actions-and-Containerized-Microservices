package com.example.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notify(String eventType, String entityId) {
        for (Observer observer : observers) {
            observer.update(eventType, entityId);
        }
    }
}
