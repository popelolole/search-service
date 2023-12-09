FROM maven:3.8.5-openjdk-18-slim AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM adoptopenjdk:11-jre-hotspot
WORKDIR /app
COPY --from=builder /app/target/*-runner.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]