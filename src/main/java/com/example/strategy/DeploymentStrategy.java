package com.example.strategy;

// Design Pattern: Strategy
public interface DeploymentStrategy {
    void deploy(String imageName, String version);
}
