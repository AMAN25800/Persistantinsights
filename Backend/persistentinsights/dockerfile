# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy only the necessary files first for better caching
COPY pom.xml .
COPY src ./src

# Build the project and skip tests
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /target/*.jar app.jar

# Expose port
EXPOSE 8080

# Use dynamic PORT from Render if provided
ENV PORT 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
