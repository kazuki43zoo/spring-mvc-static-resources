# spring-mvc-static-resources
Demo application for static resources processing on Spring Framework

[![Java CI with Maven](https://github.com/kazuki43zoo/spring-mvc-static-resources/actions/workflows/maven.yml/badge.svg)](https://github.com/kazuki43zoo/spring-mvc-static-resources/actions/workflows/maven.yml)

## shared-static-resources

Install the shared-static-resources.

```
$ ./mvnw -pl shared-static-resources clean install
```

## pure-spring-demo

Demo for traditional web application(without spring-boot).

```
$ ./mvnw -pl pure-spring-demo clean verify
```

Run with Tomcat 9.0.x using cargo maven plugin.

```
$ ./mvnw -pl pure-spring-demo clean package cargo:run
```

## spring-boot-demo

Demo for spring boot based web application.

```
$ ./mvnw -pl spring-boot-demo clean verify
```
