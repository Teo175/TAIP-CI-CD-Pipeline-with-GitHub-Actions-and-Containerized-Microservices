package com.example.decorator;

import com.example.strategy.DeploymentStrategy;

public class NotificationDecorator extends DeploymentDecorator {
    public NotificationDecorator(DeploymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void deploy(String imageName, String version) {
        System.out.println("[NOTIFICATION] Sending deployment notification...");
        wrappedStrategy.deploy(imageName, version);
        System.out.println("[NOTIFICATION] Team notified of deployment");
    }
}
