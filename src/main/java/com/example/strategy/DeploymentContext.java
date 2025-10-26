package com.example.strategy;


public class DeploymentContext {
    private DeploymentStrategy strategy;

    public void setStrategy(DeploymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeDeployment(String imageName, String version) {
        strategy.deploy(imageName, version);
    }
}
