# Lab 4 - Design Patterns Implementation

## Implemented Design Patterns

### 1. **Builder Pattern** (`builder/`)
- **Purpose**: Construct complex objects step-by-step
- **Classes**: `ProjectBuilder`, `TaskBuilder`, `ReportBuilder`
- **Use Case**: Creating Project, Task, and Report entities with optional fields

### 2. **Strategy Pattern** (`strategy/`)
- **Purpose**: Define interchangeable deployment algorithms
- **Classes**: `DeploymentStrategy`, `EKSDeploymentStrategy`, `LocalDeploymentStrategy`, `DeploymentContext`
- **Use Case**: Switch between EKS and local deployment strategies

### 3. **Decorator Pattern** (`decorator/`)
- **Purpose**: Add responsibilities to deployments dynamically
- **Classes**: `DeploymentDecorator`, `LoggingDecorator`, `HealthCheckDecorator`, `NotificationDecorator`
- **Use Case**: Enhance deployments with logging, health checks, and notifications

### 4. **Observer Pattern** (`observer/`)
- **Purpose**: Notify observers of entity changes
- **Classes**: `Observer`, `EventManager`, `ReportObserver`
- **Use Case**: Trigger report generation when tasks/projects change

### 5. **AOP (Aspect-Oriented Programming)** (`aop/`)
- **Purpose**: Cross-cutting concerns (logging, monitoring)
- **Classes**: `LoggingAspect`
- **Framework**: AspectJ (for Spring) or manual proxy
- **Use Case**: Log method execution across all services

## Framework Design Patterns

### Singleton Pattern
- **Where**: `DatabaseManager` (config/)
- **Framework**: Built-in pattern for database connections

### Factory Pattern
- **Where**: `ReportFactory` (factory/)
- **Framework**: Used for creating different report types

### Repository Pattern
- **Where**: `ProjectRepository`, `TaskRepository` (repository/)
- **Framework**: Data access abstraction pattern

## CI/CD Pipeline Patterns

- **Strategy**: Deployment strategies (EKS vs Local)
- **Decorator**: Pipeline enhancements (logging, health checks)
- **Observer**: Event-driven notifications
- **Builder**: Configuration objects for deployments

## AI Usage in Laboratory Tasks

### AI Tool Used
**Claude 4.5** - AI assistant integrated for code generation and architecture design

### How AI Was Used

1. **Design Pattern Implementation**
   - Generated boilerplate code for Builder, Strategy, Decorator, and Observer patterns
   - Ensured patterns followed best practices and Java conventions

2. **Architecture Design**
   - Suggested appropriate patterns for microservices deployment scenarios
   - Recommended Strategy pattern for multiple deployment targets (EKS/Local)
   - Proposed Decorator for pipeline enhancements (logging, health checks)

### Advantages of Using AI

✅ **Speed**: Generated 15+ classes in minutes vs hours of manual coding
✅ **Consistency**: All patterns follow same coding style and structure
✅ **Best Practices**: AI suggested industry-standard implementations

### Disadvantages of Using AI

❌ **Context Understanding**: Required clear requirements to generate relevant code
❌ **Over-Engineering Risk**: AI may suggest complex solutions for simple problems

### Conclusion

AI accelerated development, but critical thinking was still required to:
- Choose appropriate patterns for CI/CD pipeline
- Integrate patterns with existing codebase
- Verify implementations match project requirements
- Understand pattern interactions for future maintenance