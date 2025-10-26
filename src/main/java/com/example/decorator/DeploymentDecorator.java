package com.example.decorator;

import com.example.strategy.DeploymentStrategy;

public abstract class DeploymentDecorator implements DeploymentStrategy {
    protected DeploymentStrategy wrappedStrategy;

    public DeploymentDecorator(DeploymentStrategy strategy) {
        this.wrappedStrategy = strategy;
    }

    @Override
    public void deploy(String imageName, String version) {
        wrappedStrategy.deploy(imageName, version);
    }
}
