package com.example.config;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

/**
 * Singleton class for managing DynamoDB client connections.
 * Ensures only one instance of the DynamoDB client exists throughout the application lifecycle.
 */
public class DynamoDBManager {

    private static volatile DynamoDBManager instance;

    private final DynamoDbClient dynamoDbClient;
    private final DynamoDbEnhancedClient enhancedClient;

    /**
     * Private constructor to prevent instantiation from outside.
     * Initializes both standard and enhanced DynamoDB clients.
     */
    private DynamoDBManager() {
        this.dynamoDbClient = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        this.enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                dynamoDbClient.close();
            } catch (Exception ignored) {}
        }));
    }

    /**
     * Thread-safe method to get the singleton instance.
     * Uses double-checked locking for optimal performance.
     */
    public static DynamoDBManager getInstance() {
        if (instance == null) {
            synchronized (DynamoDBManager.class) {
                if (instance == null) {
                    instance = new DynamoDBManager();
                }
            }
        }
        return instance;
    }

    /** Gets the standard DynamoDB client. */
    public DynamoDbClient getClient() {
        return dynamoDbClient;
    }

    /** Gets the enhanced DynamoDB client for higher-level operations. */
    public DynamoDbEnhancedClient getEnhancedClient() {
        return enhancedClient;
    }

    /** Closes the DynamoDB client connections. */
    public void close() {
        dynamoDbClient.close();
    }

    /** Prevents cloning of the singleton instance. */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }
}

