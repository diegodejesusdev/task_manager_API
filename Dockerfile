FROM openjdk:21-slim

WORKDIR /app

COPY target/TaskManager.jar /app/task-manager.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/task-manager.jar"]