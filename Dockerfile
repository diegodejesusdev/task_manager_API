FROM maven:3.9.9-eclipse-temurin-21 AS BUILD
EXPOSE 8080

ADD src/TaskManager.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]