# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17-jdk-slim
COPY target/OnlinePrototype-0.0.1-SNAPSHOT.jar OnlinePrototype-0.0.1-SNAPSHOT.jar 
EXPOSE 18080
ENTRYPOINT ["java","-jar","/OnlinePrototype-0.0.1-SNAPSHOT.jar"]