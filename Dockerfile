FROM maven:3.9.9-eclipse-temurin-21 AS BUILD
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-noble
COPY --from=BUILD /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]