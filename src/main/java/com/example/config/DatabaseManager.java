package com.example.config;

// Design Pattern: Singleton
public class DatabaseManager {
    private static DatabaseManager instance;

    private DatabaseManager() {}

    public static DatabaseManager getInstance()
    {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void connect() {}
    public void disconnect() {}
}
