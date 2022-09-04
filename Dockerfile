FROM maven:3.6.3-jdk-11 AS builder
COPY ./ ./
RUN mvn clean package -DskipTests
FROM openjdk:11.0.7-jdk-slim
COPY --from=builder /target/spring-boot-github-actions-example.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
