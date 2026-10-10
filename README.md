# Java API Automation

This repository contains a Maven-based Java REST API automation project in the `javaapiautomation101/` directory. The tests use REST Assured and include scenarios for ReqRes and the Dummy REST API example service.

## Prerequisites

- JDK 17 (the Maven compiler configuration in the nested project targets Java 17)
- Apache Maven 3.8+ or a compatible IDE with Maven support
- Network access to the sample API endpoints used by the tests

## Run the tests

Change to the Maven project directory, then run:

```bash
cd javaapiautomation101
mvn test
```

## Project layout

```text
javaapiautomation101/
  pom.xml
  src/test/java/
    com/nahidmahmud/javaapiautomation101/reqresin/  ReqRes API tests
    dummy/restapiexample/com/                     Dummy REST API tests
```

## Technology

- Java and Maven
- REST Assured for HTTP requests and response assertions
- JUnit 3 compatibility for legacy test classes and TestNG annotations for the other test classes

## Notes

The test suite calls external demo APIs, which may impose rate limits or change their responses. A test failure can therefore reflect the external service as well as the local test code. Review the test classes and `pom.xml` before upgrading the legacy testing dependencies.
