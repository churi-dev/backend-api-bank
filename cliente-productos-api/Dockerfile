FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/cliente-productos-api-0.0.1-SNAPSHOT.jar app.jar

# Expoe port
EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]