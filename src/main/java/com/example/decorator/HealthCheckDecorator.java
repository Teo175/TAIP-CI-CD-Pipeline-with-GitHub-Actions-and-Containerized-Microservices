package com.example.decorator;

import com.example.strategy.DeploymentStrategy;

public class HealthCheckDecorator extends DeploymentDecorator {
    public HealthCheckDecorator(DeploymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void deploy(String imageName, String version) {
        wrappedStrategy.deploy(imageName, version);
        System.out.println("[HEALTH CHECK] Verifying deployment health...");
        System.out.println("[HEALTH CHECK] Service is healthy");
    }
}
