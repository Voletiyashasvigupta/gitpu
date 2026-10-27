# ── Stage 1: Build ──────────────────────────────────────────────────────────
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy dependency manifests first (layer-cache optimisation)
COPY pom.xml .
COPY mvnw mvnw.cmd ./
COPY .mvn .mvn

# Download dependencies (cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy source and build the fat-jar (skip tests; Jenkins runs them separately)
COPY src src
RUN mvn clean package -DskipTests -B

# ── Stage 2: Runtime ─────────────────────────────────────────────────────────
FROM eclipse-temurin:21-jre-alpine

# Non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

WORKDIR /app

# Pull only the fat-jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]

