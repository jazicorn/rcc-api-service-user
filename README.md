<div align="center">

# rcc-api-service-user

[![Java Language](https://img.shields.io/badge/PLATFORM-OpenJDK-3A75B0.svg?style=for-the-badge)][1] [![JUnit5 Testing Framework](https://img.shields.io/badge/testing%20framework-JUnit5-26A162.svg?style=for-the-badge)][2] [![Maven Dependency Manager](https://img.shields.io/badge/dependency%20manager-Maven-AA215A.svg?style=for-the-badge)][3]

</div>

## Overview

This api creates and manages users Java code for <a href="https://recodecamp.com">recodecamp.com</a>

## :coffee: Install OpenJDK

This project uses edition 21 of Java - Java 21 LTS. 

The Java Development Kit is platform specific. Follow the instructions described in each resource for your platform.

**Windows**

- [Installing OpenJDK with the MSI installer][4]

**Ubuntu Linux**

- [How to Install Java JDK 21 on Ubuntu][5]

**macOS**

- [Install OpenJDK 21 with Homebrew][6]

### :white_check_mark: Verify your installation

To verify that OpenJDK 21 has been successfully installed on your machine, open a terminal and run the following commands:

**Java Runtime Environment**

```bash
java -version
```

You should get an ouput similar to this one:

```bash
openjdk version "21.0.3" 2024-04-16
OpenJDK Runtime Environment Homebrew (build 21.0.3)
OpenJDK 64-Bit Server VM Homebrew (build 21.0.3, mixed mode, sharing)
```

**Java Compiler**

```bash
javac -version
```

You should get an ouput similar to this one:

```bash
javac 21.0.3
```

**:runner: Run Application**

To compile, package, and immediately run the Spring Boot application, use:
```bash
./mvnw spring-boot:run  
```

To clean the project, removing all previously compiled files, then compile and package it:
```bash
mvn clean package
```

### :gear: ENV

**:whale: Docker**

In the Dockerfile:
```bash
ENV MY_VARIABLE=value
```

With docker run:
```bash
docker run -e MY_VARIABLE=value myapp
```

[1]: https://docs.oracle.com/en/java/javase/21/docs/api/index.html
[2]: https://junit.org/junit5/
[3]: https://maven.apache.org/
[4]: https://learn.microsoft.com/en-us/java/openjdk/install?source=recommendations#install-on-windows-via-msi
[5]: https://learn.microsoft.com/en-us/java/openjdk/install?source=recommendations#install-on-ubuntu
[6]: https://formulae.brew.sh/formula/openjdk@21
