# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot JAR into the container
COPY target/persistentinsights-1.0.0.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
