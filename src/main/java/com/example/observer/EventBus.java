package com.example.observer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final Map<EventType, List<Observer>> observers = new ConcurrentHashMap<>();

    /**
     * Register an observer for a single event type.
     */
    public void register(EventType type, Observer observer) {
        observers.computeIfAbsent(type, k -> new CopyOnWriteArrayList<>()).add(observer);
    }

    /**
     * Unregister an observer for a specific event type.
     */
    public void unregister(EventType type, Observer observer) {
        List<Observer> list = observers.get(type);
        if (list != null) {
            list.remove(observer);
        }
    }

    /**
     * Publish an event to all observers subscribed to its type.
     */
    public void publish(Event event) {
        List<Observer> list = observers.get(event.getType());
        if (list != null) {
            for (Observer o : list) {
                try {
                    o.onEvent(event);
                } catch (Exception ex) {
                    // log and continue notifying others
                    ex.printStackTrace();
                }
            }
        }
    }
}
