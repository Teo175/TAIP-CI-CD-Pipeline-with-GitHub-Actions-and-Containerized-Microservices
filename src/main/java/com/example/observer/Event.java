package com.example.observer;

import java.time.Instant;

public class Event {
    private final EventType type;
    private final Object payload;
    private final Instant timestamp;

    public Event(EventType type, Object payload) {
        this.type = type;
        this.payload = payload;
        this.timestamp = Instant.now();
    }

    public EventType getType() { return type; }
    public Object getPayload() { return payload; }
    public Instant getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", payload=" + payload +
                ", timestamp=" + timestamp +
                '}';
    }
}
