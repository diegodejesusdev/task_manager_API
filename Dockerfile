FROM maven:3.9.9-eclipse-temurin-21 AS BUILD
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-noble
WORKDIR /app
COPY --from=BUILD /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]