# Spring Framework Dependency Injection Projects

This repository contains Spring Framework projects demonstrating different types of Dependency Injection (DI) patterns. These projects showcase how Spring's Inversion of Control (IoC) container manages object dependencies using XML-based configuration.

## Table of Contents

- [Overview](#overview)
- [Projects](#projects)
  - [ConstructorInjection](#constructorinjection)
  - [SetterInjection](#setterinjection)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [How It Works](#how-it-works)
- [Configuration](#configuration)

## Overview

These projects demonstrate two fundamental dependency injection patterns in Spring Framework:
1. **Constructor Injection** - Dependencies are injected through constructors
2. **Setter Injection** - Dependencies are injected through setter methods

Both projects use XML-based configuration files (`spring-config.xml`) to define beans and their dependencies, following the Spring Framework's traditional configuration approach.

## Projects

### ConstructorInjection

This project demonstrates **constructor-based dependency injection** in Spring Framework.

**Key Components:**
- `OS.java` - A simple operating system class with an `operate()` method
- `Laptop.java` - A laptop class that depends on OS, injected via constructor
- `FirstApplication.java` - Main application class that loads Spring context and executes the demo
- `spring-config.xml` - XML configuration defining beans with constructor injection

**How it works:**
- The `Laptop` class receives `OS` dependency through its constructor
- Spring container injects the OS bean when creating Laptop bean
- Configuration uses `<constructor-arg>` tag in XML

**Configuration Example:**
```xml
<bean id="os" class="com.example.demo.OS"/>
<bean id="laptop" class="com.example.demo.Laptop">
    <constructor-arg ref="os"/>
</bean>
```

### SetterInjection

This project demonstrates **setter-based dependency injection** in Spring Framework.

**Key Components:**
- `OS.java` - A simple operating system class with an `operate()` method
- `Laptop.java` - A laptop class with a setter method for OS dependency
- `SetterInjectionApplication.java` - Main application class that loads Spring context and executes the demo
- `spring-config.xml` - XML configuration defining beans with setter injection

**How it works:**
- The `Laptop` class has a setter method `setOs(OS os)` for dependency injection
- Spring container injects the OS bean using the setter method
- Configuration uses `<property>` tag in XML

**Configuration Example:**
```xml
<bean id="ios" class="com.example.demo.OS"/>
<bean id="laptop" class="com.example.demo.Laptop">
    <property name="os" ref="ios"/>
</bean>
```

## Prerequisites

Before running these projects, ensure you have the following installed:

- **Java Development Kit (JDK)** - Version 17 or higher
- **Maven** - For building and managing dependencies
- **IDE** - IntelliJ IDEA, Eclipse, or VS Code (optional but recommended)

## Project Structure

```
.
├── spring/
│   ├── ConstructorInjection/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/
│   │   │   │   │   └── com/example/demo/
│   │   │   │   │       ├── FirstApplication.java
│   │   │   │   │       ├── Laptop.java
│   │   │   │   │       └── OS.java
│   │   │   │   └── resources/
│   │   │   │       └── spring-config.xml
│   │   │   └── test/
│   │   ├── pom.xml
│   │   └── target/
│   └── SetterInjection/
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/
│       │   │   │   └── com/example/demo/
│       │   │   │       ├── SetterInjectionApplication.java
│       │   │   │       ├── Laptop.java
│       │   │   │       └── OS.java
│       │   │   └── resources/
│       │   │       └── spring-config.xml
│       │   └── test/
│       ├── pom.xml
│       └── target/
└── README.md
```

## Getting Started

### Running ConstructorInjection Project

1. Navigate to the ConstructorInjection directory:
   ```bash
   cd spring/ConstructorInjection
   ```

2. Build the project using Maven:
   ```bash
   mvn clean compile
   ```

3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.demo.FirstApplication"
   ```

   Or run directly from your IDE by executing `FirstApplication.java`

### Running SetterInjection Project

1. Navigate to the SetterInjection directory:
   ```bash
   cd spring/SetterInjection
   ```

2. Build the project using Maven:
   ```bash
   mvn clean compile
   ```

3. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.demo.SetterInjectionApplication"
   ```

   Or run directly from your IDE by executing `SetterInjectionApplication.java`

## How It Works

### Constructor Injection Flow

1. Spring container reads `spring-config.xml`
2. Creates OS bean instance
3. Creates Laptop bean instance, passing OS as constructor argument
4. When `laptop.build()` is called, it uses the injected OS dependency

### Setter Injection Flow

1. Spring container reads `spring-config.xml`
2. Creates OS bean instance (named "ios")
3. Creates Laptop bean instance
4. Calls `setOs()` method to inject OS dependency
5. When `laptop.build()` is called, it uses the injected OS dependency

## Configuration

Both projects use Spring's XML-based configuration. The configuration files define:

- **Bean Definitions**: Objects managed by Spring container
- **Dependency Injection**: How beans depend on each other
- **Bean Scope**: Default is singleton (one instance per container)

### Key Spring XML Elements

- `<beans>` - Root element containing all bean definitions
- `<bean>` - Defines a bean with id and class
- `<constructor-arg>` - Used for constructor injection
- `<property>` - Used for setter injection

## Output

When you run either application, you should see output similar to:

```
OS is operating
Laptop is building
```

This demonstrates that:
- The OS dependency was successfully injected
- The Laptop can use the OS functionality
- Spring container managed the object creation and dependency wiring

## Technologies Used

- **Spring Framework** - Core Spring container with IoC/DI
- **Spring Boot** - Version 3.4.0 (parent POM)
- **Maven** - Build tool and dependency management
- **Java** - Programming language (JDK 17)

## Learning Objectives

By exploring these projects, you will learn:

1. How Spring Framework manages object dependencies
2. Difference between constructor and setter injection
3. XML-based bean configuration in Spring
4. How Spring's IoC container works
5. Best practices for dependency injection

## Differences Between Constructor and Setter Injection

| Aspect | Constructor Injection | Setter Injection |
|--------|---------------------|------------------|
| **Timing** | Injected when object is created | Injected after object creation |
| **Mandatory** | Dependencies are required | Dependencies can be optional |
| **Immutability** | Supports immutable objects | Allows changes after creation |
| **XML Tag** | `<constructor-arg>` | `<property>` |
| **Use Case** | Required dependencies | Optional dependencies |

## Notes

- These projects use Spring Framework's traditional XML configuration
- Modern Spring applications often use annotation-based configuration (`@Autowired`, `@Component`, etc.)
- XML configuration is still useful for legacy systems and when you need external configuration

## License

This is an educational project demonstrating Spring Framework concepts.

