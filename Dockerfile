FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /app/src
COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package -DskipTests
FROM openjdk:17-alpine

COPY --from=maven-builder app/target/OnlinePrototype-0.0.1-SNAPSHOT.jar /app-service/OnlinePrototype-0.0.1-SNAPSHOT.jar
WORKDIR /app-service

EXPOSE 18080
ENTRYPOINT ["java","-jar","OnlinePrototype-0.0.1-SNAPSHOT.jar"]