# Stage 1: Build the project using Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR using OpenJDK
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Use dynamic PORT from Render if provided
ENV PORT 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
