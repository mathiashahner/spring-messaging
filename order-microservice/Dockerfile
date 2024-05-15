FROM openjdk:21-jdk AS build

WORKDIR /api

COPY .mvn .mvn
COPY src src
COPY mvnw mvnw
COPY pom.xml pom.xml

RUN ./mvnw clean package -DskipTests

RUN cp target/*.jar order-microservice.jar
ENTRYPOINT ["java", "-jar", "order-microservice.jar"]
