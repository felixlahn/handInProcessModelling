# Camunda BPMN project template

A template project used to quickstart a Camunda BPMN project

## Development

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

Für die statische Codeanalyse kann [pmd](https://pmd.github.io/) verwendet werden. Ein grundlegendes Ruleset ist in `./ruleset/java/jpinpoint-rules.xml` abgelegt. Sofern pmd installiert ist, kann der Check mit

```cmd
pmd check -R .\rulesets\java\* -d .\src\ -r .\check.txt
```

gestartet werden.

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
- Load tests
- Process measurement (min 3 KPIs)
- CI/CD-Pipeline machen (ev. Github Actions?)
