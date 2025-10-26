package com.example;

import com.example.builder.*;
import com.example.decorator.*;
import com.example.observer.*;
import com.example.strategy.*;
import com.example.model.*;

public class Main {
    public static void main(String[] args) {
        // Builder Pattern
        Project project = new ProjectBuilder()
                .id("p1")
                .name("CI/CD Pipeline")
                .description("Microservices deployment")
                .build();

        Task task = new TaskBuilder()
                .id("t1")
                .projectId("p1")
                .title("Deploy to EKS")
                .status("IN_PROGRESS")
                .build();

        // Observer Pattern
        EventManager eventManager = new EventManager();
        eventManager.subscribe(new ReportObserver());
        eventManager.notify("TASK_CREATED", task.getId());

        // Strategy + Decorator Pattern
        DeploymentStrategy deployment = new EKSDeploymentStrategy();
        deployment = new LoggingDecorator(deployment);
        deployment = new HealthCheckDecorator(deployment);

        DeploymentContext context = new DeploymentContext();
        context.setStrategy(deployment);
        context.executeDeployment("task-service", "v1.0");
    }
}
