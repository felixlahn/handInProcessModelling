# Camunda BPMN project template

A template project used to quickstart a Camunda BPMN project

## Development

### Git Workflow & CI/CD

There is a Pipeline running on every push or Pull Request that happens on main. It tests and builds the project on a linux machine as well as tries to build a docker image. If there is a Release created on Github, the same Pipeline is run again, but there will also be put the docker image to ghcr.io.

### Environment

As the development environment VS Code with the following plugins is the recommende IDE:

- redhat.java
- alexkrechik.cucumberautocomplete

For the development at least the following components need to be installed to run and develop the example:

- Java 11
- Maven

For the development of BPMN and DMN diagrams the [Camunda Modeler](https://camunda.com/de/download/modeler/) has to be used.

### Run the application

To run the application execute the following maven command:

```
mvn spring-boot:run
```

The application starts on http://localhost:8080

The default user name and password is specified in the file src/main/resources/application.yaml

### Execute the tests

To execute the test run:

```
mvn test
```

### Camunda test documentation

- Assertion: https://github.com/camunda/camunda-bpm-assert/blob/master/docs/User_Guide_BPMN.md

### Run checkstyle

```
mvn site
```

### statische Codeanalyse

statische Codeanalyse wird mit pmd gemacht, dafür ist ein plugin installiert. Es kann mit

```cmd
mvn pmd:pmd
```

gestartet werden.

### Load Tests

Für Load Tests ist als Plugin Gatling angegeben, eine Recoreded Simulation ist in `at.fhv.RecordedSimulation`. Sofern die Applikation auf `localhost:8080` läuft, kann ein Load Test mit

```cmd
mvn gatling:test
```

gemacht werden.

# Todo

- ~~Melek: 1. Cucumber scenario~~
- ~~Felix: 2. Cucumber scenario~~
- vielleicht fällt einem von uns ein drittes scenario ein
- ~~pmd reparieren & installieren - done: neue Version von PMD installieren (von rc1 auf rc2) -> <mark>pmd wird mit maven ausgeführt: `mvn pmd:pmd`</mark>~~
- ~~felix: erinnerungsprozess~~
- ~~melek: unit test checkavailability class - (ev. auslagern der Logik in Service-Layer und in checkavailability-class injecten, so könnte man bessere Tests machen)~~
- ~~melek: ist der benotungsprozess schon fertig?~~
- ~~felix & melek: unit tests & integration tests~~
- ~~felix: createstudent form reparieren~~
- ~~Load tests~~
- Process measurement (min 3 KPIs)
- ~~CI/CD-Pipeline machen (ev. Github Actions?)~~
