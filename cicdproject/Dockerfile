# Using Microsoft Container Registry to bypass Docker Hub network timeouts
FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

WORKDIR /app

# Copy the pre-built jar from Maven
COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
