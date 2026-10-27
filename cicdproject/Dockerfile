FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the fat JAR built by the Maven checkout step
COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
