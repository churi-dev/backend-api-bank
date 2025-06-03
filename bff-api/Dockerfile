FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/bff-api-0.0.1-SNAPSHOT.jar app.jar

# Expoe port
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]