FROM maven:3.8.7-eclipse-temurin-19 as build
WORKDIR /workspace/app

COPY . .
COPY pom.xml .

RUN mvn test -ntp
RUN mvn install -ntp -DskipTests

FROM eclipse-temurin:19-jdk-alpine

EXPOSE 8080

ARG DEPENDENCY=/workspace/app/target
COPY --from=build ${DEPENDENCY}/*.jar /app/

ENTRYPOINT ["java", "-jar", "/app/handInProcessModelling-1.0.0-SNAPSHOT.jar"]