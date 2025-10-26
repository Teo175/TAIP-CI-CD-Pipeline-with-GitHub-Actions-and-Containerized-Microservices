package com.example.observer;

public class ReportObserver implements Observer {
    @Override
    public void update(String eventType, String entityId) {
        System.out.println("[REPORT] Event: " + eventType + " for entity: " + entityId);
    }
}
