# Apache Wicket in Spring Boot
This simple project contains a apache wicket configuration for spring boot.
# Features

  - Obviously Spring Boot (2.x) and Apache Wicket (8.x)
  - Spring Jpa
  - Liquibase
  - QueryDsl
  - Webjars
  - Basic Spring Security
  - Lombok
  - A nice module based structure
  - Preinstalled Bootstrap

### Installation

This project requires [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Maven](https://maven.apache.org) to run.
Install both required items before developing

A basic [Docker](https://www.docker.com) configuration is included but is not required


### Compile the code
Run a maven build
```sh
$ mvnw clean install
```
To run the dev server
```sh
$ cd web/target
$ java -Dspring.profiles.active=development -jar wicket-application.jar
```
However you can also configure it in [Intellij](https://www.jetbrains.com/idea/) to run a spring boot application

#### Plugins for Intellij

| Plugin | Page |
| ------ | ------ |
| Lombok | [Plugin Page](https://plugins.jetbrains.com/plugin/6317-lombok-plugin) |

License
----
MIT