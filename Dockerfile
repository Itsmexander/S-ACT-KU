# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

# FROM maven:3.8.1-openjdk-17-slim
# RUN mvn package -DskipTests
# EXPOSE 18080
# ENTRYPOINT ["java","-jar","target/OnlinePrototype-0.0.1-SNAPSHOT.jar"]

FROM maven:3.8.1-openjdk-17-slim AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src
# Build the application using Maven
RUN mvn package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/OnlinePrototype-0.0.1-SNAPSHOT.jar .
# Set the command to run the application
CMD ["java", "-jar", "/OnlinePrototype-0.0.1-SNAPSHOT.jar"]