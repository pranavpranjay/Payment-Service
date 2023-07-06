#FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
FROM openjdk:8-jdk-alpine
EXPOSE 8085
WORKDIR /app
RUN mkdir -p src/main/resources
ADD ./src/main/resources /src/main/resources
ADD ./target/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]