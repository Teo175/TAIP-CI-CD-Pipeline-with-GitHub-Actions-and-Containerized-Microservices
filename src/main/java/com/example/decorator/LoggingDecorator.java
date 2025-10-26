package com.example.decorator;

import com.example.strategy.DeploymentStrategy;

public class LoggingDecorator extends DeploymentDecorator {
    public LoggingDecorator(DeploymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void deploy(String imageName, String version) {
        System.out.println("[LOG] Starting deployment: " + imageName + ":" + version);
        wrappedStrategy.deploy(imageName, version);
        System.out.println("[LOG] Deployment completed");
    }
}
